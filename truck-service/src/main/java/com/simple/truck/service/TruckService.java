package com.simple.truck.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simple.entity.vehicle.Truck;
import com.simple.truck.repository.TruckRepository;

@Component
public class TruckService {

    @Inject
    private TruckRepository truckRepo;
    
    public List<Truck> getAllTrucks() {
        return truckRepo.getAllTrucks();
    }
    
    public Truck getTruckById(Long id) {
        return truckRepo.getTruckById(id);
    }
}