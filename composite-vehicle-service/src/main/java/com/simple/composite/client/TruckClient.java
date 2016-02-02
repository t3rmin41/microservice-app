package com.simple.composite.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.entity.vehicle.Truck;

//@Component
@FeignClient(value = "truck-service")
public interface TruckClient {

    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    List<Truck> getTrucks();
    
    @RequestMapping(value = "/trucks/{id}", method = RequestMethod.GET)
    Truck getTruckById(@PathVariable("id") Long id);
}

