package com.springcloud.demo;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  客户端  client1 端口号8762
 * @Author: zi_you
 * @Date: 2019/2/28 17:52
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApplication {
    @Resource
    private EurekaClient client;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/test")
    public List<User> testClient(){
        List<User> list = new ArrayList<>();
        //模拟sql 查询结果
        list.add(new User(1,"ziyou1"));
        list.add(new User(2,"ziyou2"));
        return list;
    }
    @RequestMapping("/test2")
    public String testClient2() {
        InstanceInfo info = client.getNextServerFromEureka("service",false);
        return info.getId()+","+info.getHomePageUrl()+","+info.getAppName()+","+info.getAppGroupName()+","+info.getHostName();
    }

}

