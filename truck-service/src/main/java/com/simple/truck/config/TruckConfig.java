package com.simple.truck.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.simple.truck.controller", "com.simple.truck.service", "com.simple.truck.repository"})
public class TruckConfig {
}
