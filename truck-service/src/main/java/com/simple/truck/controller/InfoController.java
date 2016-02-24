package com.simple.truck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.entity.app.SingletonUUID;

@Controller
public class InfoController {

    private static Logger log = LoggerFactory.getLogger(InfoController.class);

    private static SingletonUUID singletonUUID = SingletonUUID.INSTANCE;
    
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        log.info("Requested URL : /info for UUID : " + singletonUUID.getId());
        log.info("Application UUID : " + singletonUUID.getId());
        return "This is truck service with UUID : " + singletonUUID.getId();
    }
}
