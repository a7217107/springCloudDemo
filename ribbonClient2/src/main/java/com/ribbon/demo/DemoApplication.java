package com.ribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
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
 * @Description: 负载均衡服务器 2 端口8092
 * @Author: zi_you
 * @Date: 2019/2/25 15:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoApplication {

    @Resource
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡注释
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println(2);
        //请求client1服务
        return restTemplate.getForEntity("http://CLIENT1/test", String.class).getBody()+"ribbon2";
    }



}

