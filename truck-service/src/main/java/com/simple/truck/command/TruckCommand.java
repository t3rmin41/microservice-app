package com.simple.truck.command;

import java.util.List;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

public class TruckCommand<T> extends HystrixCommand<T> {

    private T response;
    
    public TruckCommand(String commandKey, T response) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TruckGroup"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey)));
        this.response = response;
    }

    @Override
    protected T run() throws Exception {
        return this.response;
    }

}
