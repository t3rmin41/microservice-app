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
    
    @Inject
    private TruckClient truckClient;
    
    @Inject
    private CarClient carClient;
    
    @Inject
    private RestTemplate restTemplate;
    
    public Summary getAllVehicles() {
        Summary summary = new Summary();
        try {
            Future<List<Car>> carsFuture = new VehicleCommand<List<Car>>(carClient.getAllCars().getObject()).queue();
            // since we ensured that getCars() won't return null,
            // we add carClient.getAllCars() [which can be null eventually] to not null 'cars'
            summary.getCars().addAll(carsFuture.get());
            
            Future<List<Truck>> trucksFuture = new VehicleCommand<List<Truck>>(truckClient.getTrucks().getObject()).queue();
            summary.getTrucks().addAll(trucksFuture.get());
            
            Future<Bus[]> busesFutureArr = new VehicleCommand<Bus[]>(restTemplate.getForObject(remoteUrl, Bus[].class)).queue();
            summary.getBuses().addAll(Arrays.asList(busesFutureArr.get()));
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary;
    }

    
}
