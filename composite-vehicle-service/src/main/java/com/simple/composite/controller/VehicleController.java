package com.simple.composite.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.composite.service.VehicleService;
import com.simple.entity.response.VehicleSummary;

@Controller
public class VehicleController {

    @Inject
    private VehicleService vehicleService;

    @ResponseBody
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public VehicleSummary getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

}
