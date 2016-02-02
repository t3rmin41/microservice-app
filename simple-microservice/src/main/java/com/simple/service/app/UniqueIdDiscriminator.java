package com.simple.service.app;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.Discriminator;

public class UniqueIdDiscriminator implements Discriminator<ILoggingEvent> {

    private static SingletonUUID singletonUUID = SingletonUUID.getInstance();
    
    private static final String KEY = "serviceInstanceId";
    
    private boolean started;
    
    @Override
    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        return singletonUUID.getUUID().toString();
    }

    @Override
    public String getKey() {
        return KEY;
    }
    
    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

}
