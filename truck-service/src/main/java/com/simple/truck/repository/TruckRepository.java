package com.simple.truck.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.simple.entity.vehicle.Truck;

@Repository
public class TruckRepository {

    private Map<Long, Truck> trucks = new HashMap<Long, Truck>();
    
    private TruckRepository() {
        trucks.put(1L, new Truck(){
            {
                setId(1L);
                setTitle("MAN");
                setPrice(2000.44);
            }
        });
        trucks.put(2L, new Truck(){
            {
                setId(2L);
                setTitle("Ford");
                setPrice(1500.21);
            }
        });
    }
    
    public List<Truck> getAllTrucks() {
        return new ArrayList<Truck>(trucks.values());
    }
    
    public Truck getTruckById(Long id) {
        return trucks.get(id);
    }
}
