package com.simple.composite.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class VehicleCommand<T> extends HystrixCommand<T> {

    private T response;
    
    public VehicleCommand(T response) {
        super(HystrixCommandGroupKey.Factory.asKey("VehicleGroup"));
        this.response = response;
    }

    @Override
    protected T run() throws Exception {
        return this.response;
    }
}
