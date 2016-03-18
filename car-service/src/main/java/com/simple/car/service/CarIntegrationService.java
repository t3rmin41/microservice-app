package com.simple.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.simple.entity.vehicle.Car;

@Component
public class CarIntegrationService {

    @Autowired
    private RestTemplate restTemplate;
    
    public Long createIntegrationCar(String model, String manufacturer, Double price) {
        String message = restTemplate.getForObject("http://integration-service/queue/car", String.class);
        //Message is null (need to return), integration-service is called successfully using Eureka with http://{spring.application.name}
        System.out.println(message); 
        Car car = new Car();
        car.setModel(model);
        car.setManufacturer(manufacturer);
        car.setPrice(price);
        return 0L;
    }
}
