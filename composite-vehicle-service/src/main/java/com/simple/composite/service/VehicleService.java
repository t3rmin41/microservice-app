package com.simple.composite.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.simple.entity.response.Summary;
import com.simple.entity.vehicle.Bus;
import com.simple.entity.vehicle.Car;
import com.simple.entity.vehicle.Truck;
import com.simple.composite.client.CarClient;
import com.simple.composite.client.TruckClient;

@Component
public class VehicleService {
    
    private static final String remoteUrl = "http://localhost:8888/buses";
    
    @Inject
    private TruckClient truckClient;
    
    @Inject
    private CarClient carClient;
    
    @Inject
    private RestTemplate restTemplate;
    
    public Summary getAllVehicles() {
        
        List<Car> cars = carClient.getAllCars().getObject();
        List<Truck> trucks = truckClient.getTrucks().getObject();
        
        Bus[] busesArray = restTemplate.getForObject(remoteUrl, Bus[].class);
        List<Bus> buses = Arrays.asList(busesArray);
        
        Summary summary = new Summary();
        
        summary.getCars().addAll(cars); // since we ensured that getCars() won't return null,
        // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'  
        summary.getTrucks().addAll(trucks);

        summary.setBuses(buses);
        
        return summary;
    }

}
