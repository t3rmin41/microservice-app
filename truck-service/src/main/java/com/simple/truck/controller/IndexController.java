package com.simple.truck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class IndexController {
    
    private static Logger log = LoggerFactory.getLogger(IndexController.class);
    
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        log.info("Requested URL : /");
        return "Index of simple microservice";
    }
}

