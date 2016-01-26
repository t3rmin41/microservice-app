package com.simple.service.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.service.entity.Car;
import com.simple.service.service.CarService;

@Controller
public class CarController {

    
    
    @Inject
    private CarService carService;
    
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getCars() {
        return carService.getAllCars();
    }
    
}
