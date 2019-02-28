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
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
            //数据库账号
            String user = "root";
            //数据库密码
            String pwd = "a7323321";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement statement = conn.prepareStatement("select * from user");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                User item = new User();
                item.setId(set.getInt("id"));
                item.setName(set.getString("name"));
                list.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping("/test2")
    public String testClient2() {
        InstanceInfo info = client.getNextServerFromEureka("service",false);
        return info.getId()+","+info.getHomePageUrl()+","+info.getAppName()+","+info.getAppGroupName()+","+info.getHostName();
    }

}

