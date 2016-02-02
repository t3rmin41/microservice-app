package com.simple.car.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simple.car.repository.CarRepository;
import com.simple.entity.vehicle.Car;

@Component
public class CarService {
    
    @Inject
    private CarRepository carRepo;
    
    public List<Car> getAllCars() {
        return carRepo.getAllCars();
    }
    
    public Car getCarById(Long id) {
        return carRepo.getCarById(id);
    }
}
