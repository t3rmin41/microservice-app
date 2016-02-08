package com.simple.composite.controller;

import javax.inject.Inject;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.simple.composite.service.VehicleService;
import com.simple.entity.response.Summary;
import com.simple.entity.response.VehicleResponse;

@EnableHystrix
@Controller
public class VehicleController {

    @Inject
    private VehicleService vehicleService;

    @ResponseBody
    @HystrixCommand(
            groupKey = "vehicleData",
            commandKey = "getAllVehicles",
            fallbackMethod = "errorFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
            )
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public VehicleResponse<Summary> getAllVehicles() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        Summary summary = vehicleService.getAllVehicles();
        response.setEntity(summary);
        return response;
    }

    @HystrixCommand
    private VehicleResponse<Summary> errorFallback() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        response.getErrors().add("Error getting vehicles");
        return response;
    }
    
}
