package com.simple.truck.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.simple.entity.app.SingletonUUID;
import com.simple.truck.config.HystrixConfig;
import com.simple.truck.config.TruckConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({TruckConfig.class, HystrixConfig.class})
public class TruckApplication {

    private static Logger log = LoggerFactory.getLogger(TruckApplication.class);
    
    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    public static void main(String[] args) {
        log.warn("Starting truck service with UUID " + singletonUUID.getUUID().toString());
        ApplicationContext context = SpringApplication.run(TruckApplication.class, args);
        log.warn("Application context ID : " + context.getId());
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean();
        config.getMetadataMap().put("instanceId", singletonUUID.getUUID().toString()); // set UUID to observe in Eureka
        return config;
    }
}