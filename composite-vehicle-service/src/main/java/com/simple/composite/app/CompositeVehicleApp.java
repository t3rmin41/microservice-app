package com.simple.composite.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.simple.composite.config.CompositeVehicleConfig;
import com.simple.entity.app.SingletonUUID;

@Import({CompositeVehicleConfig.class})
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class CompositeVehicleApp {
    
    private static Logger log = LoggerFactory.getLogger(CompositeVehicleApp.class);
    
    private static SingletonUUID singletonUUID = SingletonUUID.ID;
    
    public static void main(String[] args) {
        log.warn("Starting composite vehicle service with UUID " + singletonUUID.getId());
        ApplicationContext context = SpringApplication.run(CompositeVehicleApp.class, args);
        log.warn("Application context ID : " + context.getId());
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean();
        config.getMetadataMap().put("instanceId", singletonUUID.getId()); // set UUID to observe in Eureka
        return config;
    }
}
