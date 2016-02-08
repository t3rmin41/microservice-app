package com.simple.truck.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.entity.response.VehicleResponse;
import com.simple.entity.vehicle.Truck;
import com.simple.truck.command.TruckCommand;
import com.simple.truck.service.TruckService;

@Controller
public class TruckController {
    
    @Inject
    private TruckService truckService;

    @ResponseBody
    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public VehicleResponse<List<Truck>> getTrucks() {
        VehicleResponse<List<Truck>> response = new VehicleResponse<List<Truck>>();
        List<Truck> trucks = truckService.getAllTrucks();
        response.setEntity(trucks);
        
        VehicleResponse<List<Truck>> responseT = (VehicleResponse<List<Truck>>) new TruckCommand(response).execute();
        return responseT;
    }
    
    @ResponseBody
    @RequestMapping(value = "/trucks/{truckId}", method = RequestMethod.GET) 
    public VehicleResponse<Truck> getTruckById(@PathVariable("truckId") Long truckId) {
        VehicleResponse<Truck> response = new VehicleResponse<Truck>();
        Truck truck = truckService.getTruckById(truckId);
        response.setEntity(truck);
        return response;
    }
}
