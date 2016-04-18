package com.simple.soap.car.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.soap.car.repository.CarRepository;

@Component
public class CarService {
    
    @Inject
    private CarRepository carRepo;
    
}
