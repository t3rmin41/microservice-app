package com.simple.service.app;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.simple.service.config.MyAppConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({MyAppConfig.class})
public class MyApp {

    private static final UUID serviceInstanceId = UUID.randomUUID();
    
    public static void main(String[] args) {
        MDC.put("serviceInstanceId", serviceInstanceId.toString());
        System.setProperty("spring.serviceInstanceId", serviceInstanceId.toString());
        ApplicationContext context = SpringApplication.run(MyApp.class, args);
    }
}
