package com.java.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description：
 * author：丁鹏
 * date：14:18
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
@EnableEurekaClient
public class UploadStart {
    public static void main(String[] args) {
        SpringApplication.run(UploadStart.class);
    }
}
