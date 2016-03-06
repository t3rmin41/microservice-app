package com.simple.truck.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.entity.response.VehicleResponse;
import com.simple.entity.vehicle.Truck;
import com.simple.truck.service.TruckService;

@Controller
public class TruckController {
    
    @Inject
    private TruckService truckService;

    @ResponseBody
    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public VehicleResponse<List<Truck>> getTrucks() {
        VehicleResponse<List<Truck>> response = new VehicleResponse<List<Truck>>();
        response.setObject(truckService.getAllTrucks());
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/trucks/{truckId}", method = RequestMethod.GET) 
    public VehicleResponse<Truck> getTruckById(@PathVariable("truckId") Long truckId) {
        VehicleResponse<Truck> response = new VehicleResponse<Truck>();
        response.setObject(truckService.getTruckById(truckId));
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/trucks/db/{truckId}", method = RequestMethod.GET) 
    public VehicleResponse<Truck> getTruckByIdFromDatabase(@PathVariable("truckId") Long truckId) {
        VehicleResponse<Truck> response = new VehicleResponse<Truck>();
        response.setObject(truckService.getTruckByDbId(truckId));
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/createTruck/{title}/{price}", method = RequestMethod.GET)
    public VehicleResponse<Long> createNewTruck(@PathVariable("title") String title, @PathVariable("price") Double price) {
        VehicleResponse<Long> response = new VehicleResponse<Long>();
        Truck truck = new Truck();
        truck.setTitle(title);
        truck.setPrice(price);
        Long truckId = truckService.createTruck(truck);
        response.setObject(truckId);
        return response;
    }
}
