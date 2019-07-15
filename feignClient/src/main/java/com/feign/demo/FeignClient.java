package com.feign.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextListener;

import javax.annotation.Resource;

/**
 * @Description: feign 调用 端口8093
 * @Author: zi_you
 * @Date: 2019/2/27 18:59
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class FeignClient {

    @Resource
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(FeignClient.class, args);
    }
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }

    @RequestMapping("/test")
    public String test(){
        TaskQO test =new TaskQO();
        test.setBrandId(123);
        test.setPartnerId(-1);
        test.setTaskTitle("测试");
        test.setCategoryId(1);
        test.setTaskType(1);
        test.setTaskPriority(0);
        test.setPlatformId(1);
        test.setKeyword("五角星");
        test.setSortType("DEFAULT");
        test.setTaskStatus(0);
        return testService.test(test);
    }

}

