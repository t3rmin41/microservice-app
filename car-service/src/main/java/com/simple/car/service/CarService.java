package com.simple.car.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.car.jdbc.CarJdbcRepository;
import com.simple.car.repository.CarRepository;
import com.simple.entity.vehicle.Car;

@Component
public class CarService {
    
    @Inject
    private CarRepository carRepo;
    
    @Autowired
    private CarJdbcRepository carJdbcRepo;
    
    public List<Car> getAllCars() {
        List<Car> allCars = new ArrayList<Car>();
        List<Car> inMemoryCars = carRepo.getAllCars();
        List<Car> jdbcCars = carJdbcRepo.getAllCars();
        allCars.addAll(inMemoryCars);
        allCars.addAll(jdbcCars);
        return allCars;
    }
    
    public Car getCarById(Long id) {
        return carRepo.getCarById(id);
    }
    
    public Car getCarByDatabaseId(Long id) {
        return carJdbcRepo.getCarById(id);
    }
    
    public Long createCar(String model, String manufacturer, Double price) {
        Car car = new Car();
        car.setModel(model);
        car.setManufacturer(manufacturer);
        car.setPrice(price);
        return carJdbcRepo.createCar(car);
    }
}
