package com.simple.car.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.car.service.CarService;
import com.simple.entity.response.VehicleResponse;
import com.simple.entity.vehicle.Car;

@Controller
public class CarController {

    @Inject
    private CarService carService;

    @ResponseBody
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public VehicleResponse<List<Car>> getCars() {
        VehicleResponse<List<Car>> response = new VehicleResponse<List<Car>>();
        response.setObject(carService.getAllCars());
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
    public VehicleResponse<Car> getCarById(@PathVariable("carId") Long carId) {
        VehicleResponse<Car> response = new VehicleResponse<Car>();
        response.setObject(carService.getCarById(carId));
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/cars/db/{carId}", method = RequestMethod.GET)
    public VehicleResponse<Car> getCarByDatabaseId(@PathVariable("carId") Long carId) {
        VehicleResponse<Car> response = new VehicleResponse<Car>();
        response.setObject(carService.getCarByDatabaseId(carId));
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/cars/create/{model}/{manufacturer}/{price}", method = RequestMethod.GET)
    public VehicleResponse<Long> createCar(@PathVariable("model") String model, @PathVariable("manufacturer") String manufacturer, @PathVariable("price") Double price) {
        VehicleResponse<Long> response = new VehicleResponse<Long>();
        response.setObject(carService.createCar(model, manufacturer, price));
        return response;
    }
}
