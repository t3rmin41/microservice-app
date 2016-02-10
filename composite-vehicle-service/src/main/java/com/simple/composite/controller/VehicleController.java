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
        try {
            response.setObject(vehicleService.getAllVehicles());
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/slowvehicles", method = RequestMethod.GET)
    public VehicleResponse<Summary> getSlowVehicles() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        try {
            response.setObject(vehicleService.getSlowlyAllVehicles());
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/slowtolerantvehicles", method = RequestMethod.GET)
    public VehicleResponse<Summary> getSlowTolerantVehicles() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        try {
            response.setObject(vehicleService.getSlowTolerantAllVehicles());
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/remoteError", method = RequestMethod.GET)
    public VehicleResponse<Summary> getRemoteError() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        try {
            response.setObject(vehicleService.getRemoteError());
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "/nonExisting", method = RequestMethod.GET)
    public VehicleResponse<Summary> getNonExisting() {
        VehicleResponse<Summary> response = new VehicleResponse<Summary>();
        try {
            response.setObject(vehicleService.getRemoteError());
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
        }
        return response;
    }
}
