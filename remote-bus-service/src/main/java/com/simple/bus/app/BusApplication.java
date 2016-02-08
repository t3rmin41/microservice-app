package com.simple.bus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.simple.bus.config.BusAppConfig;

@Import(BusAppConfig.class)
@SpringBootApplication
public class BusApplication {

    public static void main(String args[]) {
        log.warn("Starting composite vehicle service with UUID " + singletonUUID.getUUID().toString());
        ApplicationContext context = SpringApplication.run(BusApplication.class, args);
        log.warn("Application context ID : " + context.getId());
    }
}
