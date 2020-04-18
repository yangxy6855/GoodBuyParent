package com.java.application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 * author：丁鹏
 * date：16:54
 */
@SpringBootApplication(scanBasePackages = "com.java.*")
//开启注册中心客户端
@EnableEurekaClient
//负载均衡
@EnableDiscoveryClient
@MapperScan(basePackages = "com.java.mapper")
//开启定时器任务注解
@EnableScheduling
public class WebStartApplication {

    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebStartApplication.class);
    }
}
