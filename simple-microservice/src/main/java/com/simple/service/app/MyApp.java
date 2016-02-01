package com.simple.service.app;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.simple.service.config.MyAppConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({MyAppConfig.class})
public class MyApp {

    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    public static void main(String[] args) {
        MDC.put("serviceInstanceId", singletonUUID.getUUID().toString()); // set UUID for log directory
        SpringApplication.run(MyApp.class, args);
    }

}
