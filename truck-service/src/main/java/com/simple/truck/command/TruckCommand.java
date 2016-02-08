package com.simple.truck.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.simple.entity.response.VehicleResponse;

public class TruckCommand extends HystrixCommand<VehicleResponse<?>> {

    private VehicleResponse<?> response;
    
    public TruckCommand(VehicleResponse<?> response) {
        super(HystrixCommandGroupKey.Factory.asKey("TruckGroup"));
        this.response = response;
    }

    @Override
    protected VehicleResponse<?> run() throws Exception {
        return this.response;
    }

}
