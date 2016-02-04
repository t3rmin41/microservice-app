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
import com.simple.entity.response.VehicleSummary;

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
    public VehicleSummary getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @HystrixCommand
    private VehicleSummary errorFallback() {
        VehicleSummary response = new VehicleSummary();
        response.getErrors().add("Error getting vehicles");
        return response;
    }
    
}
