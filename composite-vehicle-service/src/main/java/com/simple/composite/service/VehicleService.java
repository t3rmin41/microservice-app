package com.simple.composite.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simple.entity.response.VehicleSummary;
import com.simple.entity.vehicle.Car;
import com.simple.entity.vehicle.Truck;

import com.simple.composite.client.CarClient;
import com.simple.composite.client.TruckClient;

@Component
public class VehicleService {
    
    @Inject
    private TruckClient truckClient;
    
    @Inject
    private CarClient carClient;
    
    public VehicleSummary getAllVehicles() {
        
        List<Car> cars = carClient.getAllCars();
        List<Truck> trucks = truckClient.getTrucks();
        
        VehicleSummary summary = new VehicleSummary();
        
        summary.getCars().addAll(cars); // since we ensured that getCars() won't return null,
        // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'  
        summary.getTrucks().addAll(trucks);
        
        return summary;
    }
}
