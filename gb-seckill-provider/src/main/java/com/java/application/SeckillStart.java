package com.java.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description：
 * author：丁鹏
 * date：15:09
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@MapperScan(basePackages = "com.java.mapper")
@EnableScheduling
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCaching
@ServletComponentScan(basePackages = "com.java.filters")
public class SeckillStart {
    public static void main(String[] args) {
        SpringApplication.run(SeckillStart.class);
    }
}
