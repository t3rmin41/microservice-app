package com.simple.composite.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.entity.response.VehicleResponse;
import com.simple.entity.vehicle.Truck;

@FeignClient(value = "truck-service")
public interface TruckClient {

    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    VehicleResponse<List<Truck>> getTrucks();
    
    @RequestMapping(value = "/trucks/{id}", method = RequestMethod.GET)
    VehicleResponse<Truck> getTruckById(@PathVariable("id") Long id);
}

