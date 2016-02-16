package com.simple.entity.app;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.Discriminator;

public class UniqueIdDiscriminator implements Discriminator<ILoggingEvent> {

    private static String singletonUUID = SingletonUUID.ID.getId();
    
    private static final String KEY = "serviceInstanceId";
    
    private boolean started;
    
    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        return singletonUUID; //.getUUID().toString();
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
