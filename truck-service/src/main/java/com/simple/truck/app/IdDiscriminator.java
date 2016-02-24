package com.simple.truck.app;

import ch.qos.logback.core.sift.Discriminator;
import ch.qos.logback.core.spi.DeferredProcessingAware;

import com.simple.entity.app.SingletonUUID;

public class IdDiscriminator implements Discriminator<DeferredProcessingAware> {

    private static String uuid = SingletonUUID.INSTANCE.getId();
    
    private static final String KEY = "serviceInstanceId";
    
    private boolean started;
    
    public String getDiscriminatingValue(DeferredProcessingAware logEvent) {
        return uuid;
    }

    public String getKey() {
        return KEY;
    }
    
    public void start() {
        started = true;
    }

    public void stop() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

}