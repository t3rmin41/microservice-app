package com.simple.truck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.simple.entity.vehicle.Truck;
import com.simple.truck.command.TruckCommand;
import com.simple.truck.jpa.TruckJpa;
import com.simple.truck.jpa.TruckJpaRepository;
import com.simple.truck.repository.TruckRepository;

@EnableHystrix
@Component
public class TruckService {

    @Inject
    private TruckRepository truckRepo;
    
    @Autowired
    private TruckJpaRepository truckJpaRepo;
    
    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<Truck>();
        Future<List<Truck>> future = new TruckCommand<List<Truck>>("getTrucks", truckRepo.getAllTrucks()).queue();

        try {
            trucks = future.get();
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<TruckJpa> trucksJpa = truckJpaRepo.getAllTrucksJpa();
        for (TruckJpa jpa : trucksJpa) {
            trucks.add(new Truck(jpa.getId(), jpa.getTitle(), jpa.getPrice()));
        }

        return trucks;
    }
    
    public Truck getTruckById(Long id) {
        Truck truck = new Truck();
        Future<Truck> future = new TruckCommand<Truck>("getTruckById", truckRepo.getTruckById(id)).queue();
        
        try {
            truck = future.get();
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truck;
    }
}