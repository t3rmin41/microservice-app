package com.simple.truck.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.entity.vehicle.Truck;
import com.simple.truck.service.TruckService;

@Controller
public class TruckController {
    
    @Inject
    private TruckService truckService;
    
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Truck Service is running";
    }
    
    @ResponseBody
    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public List<Truck> getTrucks() {
        return truckService.getAllTrucks();
    }
    
    @ResponseBody
    @RequestMapping(value = "/trucks/{truckId}", method = RequestMethod.GET) 
    public Truck getTruckById(@PathVariable("truckId") Long truckId) {
        return truckService.getTruckById(truckId);
    }
}
