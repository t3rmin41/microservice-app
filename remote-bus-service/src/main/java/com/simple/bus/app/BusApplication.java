package com.simple.bus.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.simple.bus.config.BusAppConfig;

@Import(BusAppConfig.class)
@SpringBootApplication
public class BusApplication {

    private static Logger log = LoggerFactory.getLogger(BusApplication.class);
    
    public static void main(String args[]) {
        ApplicationContext context = SpringApplication.run(BusApplication.class, args);
        log.warn("Application context ID : " + context.getId());
    }
}
