package com.simple.service.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.simple.service.entity.Car;

@Service
public class CarService {

    private static Logger log = LoggerFactory.getLogger(CarService.class);
    
    public List<Car> getAllCars() {
        log.info("Getting list of cars");
        List<Car> cars = new ArrayList<Car>();
        
        Car car1 = new Car();
        car1.setId(1L);
        car1.setModel("S80");
        car1.setTitle("Volvo");
        
        Car car2 = new Car();
        car2.setId(2L);
        car2.setTitle("Toyota");
        car2.setModel("RAV4");
        
        cars.add(car1);
        cars.add(car2);
        
        log.debug("Added " + cars.size() + " cars");
        log.info("Getting list of cars completed, returning");

        return cars;
    }
}
