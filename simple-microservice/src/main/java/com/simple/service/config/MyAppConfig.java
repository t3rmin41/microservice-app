package com.simple.service.config;

import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.simple.service.app.SingletonUUID;

@Configuration
@ComponentScan(basePackages = {"com.simple.service.controller", "com.simple.service.service"})
public class MyAppConfig {

    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean();
        config.getMetadataMap().put("instanceId", singletonUUID.getUUID().toString()); // set UUID to observe in Eureka
        return config;
    }
}
