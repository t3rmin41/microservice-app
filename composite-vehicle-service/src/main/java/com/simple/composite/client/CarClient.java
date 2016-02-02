package com.simple.composite.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.entity.vehicle.Car;

@FeignClient(value = "car-service")
public interface CarClient {

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    List<Car> getAllCars();
    
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    Car getCarById(@PathVariable("id") Long id);
}
