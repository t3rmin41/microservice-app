package com.simple.composite.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommand.Setter;

public class VehicleCommand<T> extends HystrixCommand<T> {

    private T response;
    
    public VehicleCommand(T response, String groupKey, int timeout) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(timeout))
          );
        this.response = response;
    }

    /*
    //Need to try in execute() command to catch exception
    public T getResponse() {
        try {
            return this.response = this.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    /**/
    
    @Override
    protected T run() throws Exception {
        return this.response;
    }
}
