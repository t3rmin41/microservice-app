package com.simple.service.app;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonUUID {

    private static Logger log = LoggerFactory.getLogger(SingletonUUID.class);
    private static SingletonUUID instance = new SingletonUUID();

    private UUID uuid = UUID.randomUUID();

    private SingletonUUID() {
        log.info("SingletonUUID : Initializing instance with UUID : " + uuid.toString());
    }
    
    public static SingletonUUID getInstance() {
        return instance;
    }
    
    public UUID getUUID() {
        return this.uuid;
    }
}
