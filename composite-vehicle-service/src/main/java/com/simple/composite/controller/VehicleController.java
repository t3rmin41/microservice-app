package com.simple.composite.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.composite.service.VehicleService;
import com.simple.entity.response.Summary;
import com.simple.entity.response.VehicleResponse;

@Controller
public class VehicleController {

    @Inject
    private VehicleService vehicleService;

    @ResponseBody
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public VehicleResponse<Summary> getAllVehicles() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        response.setObject(vehicleService.getAllVehicles());
        return response;
    }
    
}
