package com.java.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description：
 * author：丁鹏
 * date：14:39
 */
@SpringBootApplication
//开启注册中心服务端
@EnableEurekaServer
public class Eureka1Start {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1Start.class);
    }
}
