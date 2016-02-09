package com.simple.entity.response;

import java.util.ArrayList;
import java.util.List;

import com.simple.entity.vehicle.Bus;
import com.simple.entity.vehicle.Car;
import com.simple.entity.vehicle.Truck;

public class Summary {

    private List<Car> cars = new ArrayList<Car>(); // this way we ensure that 'cars' is not null
    private List<Truck> trucks = new ArrayList<Truck>(); // this way we ensure that 'trucks' is not null
    private List<Bus> buses = new ArrayList<Bus>();
    
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public List<Truck> getTrucks() {
        return trucks;
    }
    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }
    public List<Bus> getBuses() {
        return buses;
    }
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}

