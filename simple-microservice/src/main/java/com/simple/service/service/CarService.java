package com.simple.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simple.service.entity.Car;

@Service
public class CarService {

    public List<Car> getAllCars() {
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
        
        return cars;
    }
}
