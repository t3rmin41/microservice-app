package com.simple.soap.car.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.simple.soap.car.config.CarConfig;

@SpringBootApplication
@Import({CarConfig.class})
public class CarApplication {

    private static Logger log = LoggerFactory.getLogger(CarApplication.class);
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CarApplication.class, args);
        log.warn("Application context ID : " + context.getId());
    }

}
