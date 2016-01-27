package com.simple.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {

    private static Logger log = LoggerFactory.getLogger(InfoController.class);

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        log.info("Requested URL : /info");
        log.info("Application UUID : " + System.getProperty("spring.serviceInstanceId"));
        return "This is simple service serving cars";
    }
}
