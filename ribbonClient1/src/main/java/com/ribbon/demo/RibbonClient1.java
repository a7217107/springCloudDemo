package com.ribbon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: 负载均衡 服务器1  端口8091
 * @Author: zi_you
 * @Date: 2019/2/25 15:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonClient1 {

    @Resource
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RibbonClient1.class, args);
    }


    @Bean
    /**
     * 负载均衡
     */
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println(1);
        return restTemplate.getForEntity("http://CLIENT1/test", String.class).getBody()+"ribbon1";
    }



}

