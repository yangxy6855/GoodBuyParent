package com.java.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：前台热门商品提供者
 * author：丁鹏
 * date：10:48
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@MapperScan(basePackages = "com.java.mapper")
@EnableEurekaClient
@EnableCaching//开启redis缓存
@EnableDiscoveryClient
public class HotProviderStart {
public static void main(String[] args) {
        SpringApplication.run(HotProviderStart.class);
        }
        }
