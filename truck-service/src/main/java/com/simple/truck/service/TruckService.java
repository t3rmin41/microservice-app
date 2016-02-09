package com.simple.truck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
        List<Truck> trucks = new ArrayList<Truck>();
        try {
            Future<List<Truck>> future = new TruckCommand<List<Truck>>(truckRepo.getAllTrucks()).queue();
            trucks = future.get();
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }
    
    public Truck getTruckById(Long id) {
        Truck truck = new Truck();
        try {
            Future<Truck> future = new TruckCommand<Truck>(truckRepo.getTruckById(id)).queue();
            truck = future.get();
        } catch (ExecutionException ee) {
            ee.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truck;
    }
}