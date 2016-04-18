package com.simple.soap.car.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.soap.entity.car.Car;


@Repository
public class CarRepository {

    private Map <Integer, Car> cars = new HashMap<Integer, Car>();
    
    public CarRepository() {
        cars.put(1, new Car(){
            {
                setId(1);
                setModel("730");
                setManufacturer("BMW");
                setPrice(2103.20);
            }
        });
        cars.put(2, new Car(){
            {
                setId(2);
                setModel("C300");
                setManufacturer("Chrysler");
                setPrice(1103.20);
            }
        });
    }

    public List<Car> getAllCars() {
        return new ArrayList<Car>(cars.values());
    }
    
    public Car getCarById(int i) {
        return cars.get(i);
    }
} 
