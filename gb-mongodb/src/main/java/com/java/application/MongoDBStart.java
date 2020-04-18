package com.java.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：
 * author：丁鹏
 * date：10:55
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@EnableEurekaClient
@ServletComponentScan(basePackages = "com.java.filters")
public class MongoDBStart {
    public static void main(String[] args) {
        SpringApplication.run(MongoDBStart.class);
    }
}
