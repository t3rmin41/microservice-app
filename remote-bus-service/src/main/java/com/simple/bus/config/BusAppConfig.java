package com.simple.bus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.simple.bus.controller", "com.simple.bus.service"})
public class BusAppConfig {

}
