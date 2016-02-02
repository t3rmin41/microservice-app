package com.simple.service.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.simple.service.config.MyAppConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({MyAppConfig.class})
public class MyApp {

    private static Logger log = LoggerFactory.getLogger(MyApp.class);
    
    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    public static void main(String[] args) {
        log.warn("Starting service with UUID " + singletonUUID.getUUID().toString());
        ApplicationContext context = SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean();
        config.getMetadataMap().put("instanceId", singletonUUID.getUUID().toString()); // set UUID to observe in Eureka
        return config;
    }
}
