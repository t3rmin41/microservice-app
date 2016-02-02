package com.simple.composite.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.simple.composite.config.CompositeVehicleConfig;
import com.simple.entity.app.SingletonUUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Import({CompositeVehicleConfig.class})
public class CompositeVehicleApp {
    
    private static Logger log = LoggerFactory.getLogger(CompositeVehicleApp.class);
    
    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    public static void main(String[] args) {
        log.warn("Starting composite vehicle service with UUID " + singletonUUID.getUUID().toString());
        ApplicationContext context = SpringApplication.run(CompositeVehicleApp.class, args);
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean();
        config.getMetadataMap().put("instanceId", singletonUUID.getUUID().toString()); // set UUID to observe in Eureka
        return config;
    }
}
