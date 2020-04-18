package com.java.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：
 * author：丁鹏
 * date：09:16
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@EnableCaching
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(basePackages = "com.java.mapper")
public class BuyCarStart {
    public static void main(String[] args) {
        SpringApplication.run(BuyCarStart.class);
    }
}
