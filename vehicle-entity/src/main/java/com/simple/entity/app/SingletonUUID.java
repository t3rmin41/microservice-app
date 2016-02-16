package com.simple.entity.app;

import java.util.UUID;

public enum SingletonUUID {
    
    ID;
    
    //private static SingletonUUID instance = new SingletonUUID();

    private UUID uuid = UUID.randomUUID();

    private SingletonUUID() {
    }
    
    public String getId() {
        return this.uuid.toString();
    }
    
//    public static SingletonUUID getInstance() {
//        return instance;
//    }
//    
//    public UUID getUUID() {
//        return this.uuid;
//    }
}