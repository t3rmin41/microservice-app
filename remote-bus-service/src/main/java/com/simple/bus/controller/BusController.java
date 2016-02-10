package com.simple.bus.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.bus.service.BusService;

@Controller
public class BusController {

    @Inject
    private BusService busService;
    
    @ResponseBody
    @RequestMapping(value = "/buses", method = RequestMethod.GET)
    public String getBuses() {
        return busService.getAllBuses();
    }
    
    @ResponseBody
    @RequestMapping(value = "/slowBuses", method = RequestMethod.GET)
    public String getSlowBuses() {
        String buses = null;
        try {
            Thread.sleep(3000);
            buses = busService.getAllBuses();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buses;
    }
    
    @ResponseBody
    @RequestMapping(value = "/internalErrorUrl", method = RequestMethod.GET)
    public String getInternalError() {
        throw new RuntimeException("Exception from remote bus service");
    }
    
}
