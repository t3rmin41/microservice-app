package com.simple.truck.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.simple.entity.vehicle.Truck;
import com.simple.truck.command.TruckCommand;
import com.simple.truck.repository.TruckRepository;

@Component
public class TruckService {

    @Inject
    private TruckRepository truckRepo;
    
    public List<Truck> getAllTrucks() {
        return new TruckCommand<List<Truck>>(truckRepo.getAllTrucks()).execute();
    }
    
    public Truck getTruckById(Long id) {
        return new TruckCommand<Truck>(truckRepo.getTruckById(id)).execute();
    }
}