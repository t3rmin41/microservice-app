package com.simple.composite.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.simple.entity.response.Summary;
import com.simple.entity.response.VehicleResponse;
import com.simple.entity.vehicle.Bus;
import com.simple.entity.vehicle.Car;
import com.simple.entity.vehicle.Truck;
import com.simple.composite.client.CarClient;
import com.simple.composite.client.TruckClient;
import com.simple.composite.command.VehicleCommand;

@EnableHystrix
@Component
public class VehicleService {
    
    private static final String remoteUrl = "http://localhost:8888/buses";
    private static final String errorUrl = "http://localhost:8888/internalErrorUrl";
    private static final String nonExistingUrl = "http://localhost:8888/nonExisting";
    private static final String slowUrl = "http://localhost:8888/slowBuses";
    
    @Inject
    private TruckClient truckClient;
    
    @Inject
    private CarClient carClient;
    
    @Inject
    private RestTemplate restTemplate;
    
    public Summary getAllVehicles() {
            Summary summary = new Summary();
            
            Bus[] busesArr = new VehicleCommand<Bus[]>("getBuses", restTemplate, remoteUrl, Bus[].class, 300).execute();
            summary.getBuses().addAll(Arrays.asList(busesArr));
            
            List<Car> cars = new VehicleCommand<List<Car>>("getCars", carClient.getAllCars().getObject(), 300).execute();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(cars);
            
            List<Truck> trucks = new VehicleCommand<List<Truck>>("getTrucks", truckClient.getTrucks().getObject(), 300).execute();
            summary.getTrucks().addAll(trucks);
            
            return summary;
    }

    public Summary getSlowTolerantAllVehicles() {
        Summary summary = new Summary();
        
        Bus[] busesArr = new VehicleCommand<Bus[]>("getSlowTolerantBuses", restTemplate, slowUrl, Bus[].class, 6000).execute();
        summary.getBuses().addAll(Arrays.asList(busesArr));
        
        List<Car> cars= new VehicleCommand<List<Car>>("getCars", carClient.getAllCars().getObject(), 6000).execute();
        // since we ensured that getCars() won't return null,
        // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
        summary.getCars().addAll(cars);
        
        List<Truck> trucks = new VehicleCommand<List<Truck>>("getTrucks", truckClient.getTrucks().getObject(), 6000).execute();
        summary.getTrucks().addAll(trucks);
        
        return summary;
    }
    
    public Summary getSlowAllVehicles() {
            Summary summary = new Summary();
            
            Bus[] busesArr = new VehicleCommand<Bus[]>("getSlowBuses", restTemplate, slowUrl, Bus[].class, 300).execute();
            summary.getBuses().addAll(Arrays.asList(busesArr));
            
            List<Car> cars= new VehicleCommand<List<Car>>("getCars", carClient.getAllCars().getObject(), 300).execute();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(cars);
            
            List<Truck> trucks = new VehicleCommand<List<Truck>>("getTrucks", truckClient.getTrucks().getObject(), 300).execute();
            summary.getTrucks().addAll(trucks);
            
            return summary;
    }
    


    public Summary getRemoteError() {
            Summary summary = new Summary();

            Bus[] busesArr = new VehicleCommand<Bus[]>("getErrorBuses", restTemplate, errorUrl, Bus[].class, 300).execute();
            summary.getBuses().addAll(Arrays.asList(busesArr));
            
            List<Car> cars= new VehicleCommand<List<Car>>("getCars", carClient.getAllCars().getObject(), 300).execute();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(cars);
            
            List<Truck> trucks = new VehicleCommand<List<Truck>>("getTrucks", truckClient.getTrucks().getObject(), 300).execute();
            summary.getTrucks().addAll(trucks);
            
            return summary;
    }
    
    public Summary getNonExistingUrl() {
            Summary summary = new Summary();
            
            Bus[] busesArr = new VehicleCommand<Bus[]>("getNonExistingBuses", restTemplate, nonExistingUrl, Bus[].class, 300).execute();
            summary.getBuses().addAll(Arrays.asList(busesArr));
            
            List<Car> cars= new VehicleCommand<List<Car>>("getCars", carClient.getAllCars().getObject(), 300).execute();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(cars);
            
            List<Truck> trucks = new VehicleCommand<List<Truck>>("getTrucks", truckClient.getTrucks().getObject(), 300).execute();
            summary.getTrucks().addAll(trucks);
            
            return summary;
    }
}
