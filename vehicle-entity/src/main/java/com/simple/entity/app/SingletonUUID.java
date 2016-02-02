package com.simple.entity.app;

import java.util.UUID;

public class SingletonUUID {
    
    private static SingletonUUID instance = new SingletonUUID();

    private UUID uuid = UUID.randomUUID();

    private SingletonUUID() {
    }
    
    public static SingletonUUID getInstance() {
        return instance;
    }
    
    public UUID getUUID() {
        return this.uuid;
    }
}