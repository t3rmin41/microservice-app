package com.simple.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.simple.service.controller", "com.simple.service.service"})
public class MyAppConfig {

}
