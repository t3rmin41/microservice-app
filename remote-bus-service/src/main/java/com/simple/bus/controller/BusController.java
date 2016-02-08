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
}
