package com.simple.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.bus.jdbc.BusJdbcRepository;

@Component
public class BusService {

    @Autowired
    private BusJdbcRepository busRepo;
    
    public String getAllBuses() {
        return "[{" + getJdbcBuses() +", \"id\": \"2\", \"model\": \"Ikarus\", \"capacity\": \"50\"}, {\"id\": \"3\", \"model\": \"Mercedes\", \"capacity\": \"65\"}]";
    }
    
    public String getJdbcBuses() {
        String busesString = "";
        List<Bus> buses = busRepo.getAllBuses();
        for(int i = 0; i < buses.size(); i++) {
            busesString += buses.get(i).toString();
            if (i + 1 < buses.size()) {
                busesString += ", ";
            }
        }
        return busesString;
    }
    
    public Long createBus(String model, Long capacity) {
        Bus bus = new Bus();
        bus.setModel(model);
        bus.setCapacity(capacity);
        return busRepo.createBus(bus, true);
    }
}
