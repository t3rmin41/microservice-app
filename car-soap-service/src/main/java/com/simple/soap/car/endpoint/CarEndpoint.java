package com.simple.soap.car.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.simple.soap.car.repository.CarRepository;
import com.simple.soap.entity.car.GetCarRequest;
import com.simple.soap.entity.car.GetCarResponse;

@Endpoint
public class CarEndpoint {

    private static final String NAMESPACE_URI = "http://entity.soap.simple.com/car";

    private CarRepository carRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCountry(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carRepository.getCarById(request.getId()));

        return response;
    }
}
