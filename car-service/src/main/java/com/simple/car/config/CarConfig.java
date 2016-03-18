package com.simple.car.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.simple.car.controller", "com.simple.car.service", "com.simple.car.repository", "com.simple.car.jdbc"})
public class CarConfig {

}
