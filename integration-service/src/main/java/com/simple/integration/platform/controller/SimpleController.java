package com.simple.integration.platform.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.integration.platform.jms.JmsReceiver;
import com.simple.integration.platform.jms.JmsSender;

@RestController
public class SimpleController {

    @Autowired
    private ConfigurableApplicationContext context;

    @RequestMapping(value = "/queue/car", method = RequestMethod.GET)
    public String queueNewCar() {
        JmsSender jmsSender = (JmsSender) context.getBean("jmsMqSender");
        jmsSender.sendText("Car created at " + new Date());
        JmsReceiver jmsReceiver = (JmsReceiver) context.getBean("jmsMqReceiver");
        return jmsReceiver.getMessage();
    }
}
