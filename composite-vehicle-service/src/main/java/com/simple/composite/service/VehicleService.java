package com.simple.composite.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.simple.entity.response.Summary;
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
    private static final String nonExistingUrl = "http://localhost:8888/internalErrorUrl";
    private static final String slowUrl = "http://localhost:8888/slowBuses";
    
    @Inject
    private TruckClient truckClient;
    
    @Inject
    private CarClient carClient;
    
    @Inject
    private RestTemplate restTemplate;
    
    public Summary getAllVehicles() throws Exception {
        try {
            Summary summary = new Summary();
            
            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(remoteUrl, Bus[].class), "VehicleGroup", 100).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
            
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject(), "VehicleGroup", 100).queue();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject(), "VehicleGroup", 100).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            return summary;
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public Summary getSlowlyAllVehicles() throws Exception {
        try {
            Summary summary = new Summary();
            
            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(slowUrl, Bus[].class), "VehicleGroup", 2000).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
            
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject(), "VehicleGroup", 2000).queue();
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject(), "VehicleGroup", 2000).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            return summary;
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public Summary getSlowTolerantAllVehicles() throws Exception {
        try {
            Summary summary = new Summary();
            
            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(slowUrl, Bus[].class), "VehicleGroup", 6000).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
            
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject(), "VehicleGroup", 6000).queue();
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject(), "VehicleGroup", 6000).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            return summary;
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Summary getRemoteError() throws Exception {
        try {
            Summary summary = new Summary();

            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(errorUrl, Bus[].class), "VehicleGroup", 100).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
            
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject(), "VehicleGroup", 100).queue();
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject(), "VehicleGroup", 100).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            return summary;
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public Summary getNonExistingUrl() throws Exception {
        try {
            Summary summary = new Summary();
            
            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(nonExistingUrl, Bus[].class), "VehicleGroup", 100).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
            
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject(), "VehicleGroup", 100).queue();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject(), "VehicleGroup", 100).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            return summary;
        } catch (ExecutionException ee) {
            ee.printStackTrace();
            throw new Exception(ee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
