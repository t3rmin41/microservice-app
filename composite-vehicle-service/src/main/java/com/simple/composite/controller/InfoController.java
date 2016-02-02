package com.simple.composite.controller;

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

    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        log.info("Requested URL : /info for UUID : " + singletonUUID.getUUID());
        log.info("Application UUID : " + singletonUUID.getUUID());
        return "This is composite vehicle service with UUID : " + singletonUUID.getUUID().toString();
    }
}
