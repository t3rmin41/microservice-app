package com.simple.service.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.service.entity.Car;
import com.simple.service.service.CarService;

@Controller
public class CarController {

    private static Logger log = LoggerFactory.getLogger(CarController.class);
    
    @Inject
    private CarService carService;
    
    @ResponseBody
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getCars() {
        log.info("Request URL : /cars");
        log.debug("Will return JSON of cars");
        return carService.getAllCars();
    }
    
}
