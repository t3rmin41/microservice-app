package com.simple.truck.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class TruckCommand<T> extends HystrixCommand<T> {

    private T response;
    
    public TruckCommand(T response) {
        super(HystrixCommandGroupKey.Factory.asKey("TruckGroup"));
        this.response = response;
    }

    @Override
    protected T run() throws Exception {
        return this.response;
    }

}
