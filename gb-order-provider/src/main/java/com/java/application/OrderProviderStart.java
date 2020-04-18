package com.java.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：结算模块
 * author：丁鹏
 * date：11:35
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@MapperScan(basePackages = "com.java.mapper")
@EnableCaching
@EnableDiscoveryClient
@EnableEurekaClient
public class OrderProviderStart {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderStart.class);
    }
}
