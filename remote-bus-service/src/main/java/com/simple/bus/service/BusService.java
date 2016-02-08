package com.simple.bus.service;

import org.springframework.stereotype.Component;

@Component
public class BusService {

    public String getAllBuses() {
        return "[{\"model\": \"Ikarus\", \"capacity\": \"50\"}, {\"model\": \"Mercedes\", \"capacity\": \"65\"}]";
    }
}
