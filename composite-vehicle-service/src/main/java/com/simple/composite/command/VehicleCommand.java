package com.simple.composite.command;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class VehicleCommand<T> extends HystrixCommand<T> {

    private String url;
    private RestTemplate restTemplate;
    private Class<T> clazz;
    private T response;
    
    public VehicleCommand(String groupKey, String commandKey, RestTemplate restTemplate, String url, Class<T> clazz, int timeout) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(timeout))
          );
        this.url = url;
        this.restTemplate = restTemplate;
        this.clazz = clazz;
    }
    
    public VehicleCommand(String groupKey, String commandKey, T response, int timeout) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
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
        return null == response ? restTemplate.getForObject(url, clazz) : response;
    }

}
