package com.feign.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: feign 调用
 * @Author: zi_you
 * @Date: 2019/2/27 18:59
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class DemoApplication {

    @Resource
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return testService.test();
    }

}

