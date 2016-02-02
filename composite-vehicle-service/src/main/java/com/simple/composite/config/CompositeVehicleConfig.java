package com.simple.composite.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.simple.composite.client"})
@ComponentScan(basePackages = {"com.simple.composite.controller", "com.simple.composite.service"})
public class CompositeVehicleConfig {

}
