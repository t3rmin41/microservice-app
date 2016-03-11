package com.simple.entity.vehicle;

public class Bus {

    private Long id;
    private String model;
    private Long capacity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Long getCapacity() {
        return capacity;
    }
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + this.id + "\", \"model\": \"" + this.model + "\", \"capacity\": \"" + this.capacity + "\" }";
    }
    
    //return "[{\"id\": \"1\", \"model\": \"Ikarus\", \"capacity\": \"50\"}, {\"id\": \"2\", \"model\": \"Mercedes\", \"capacity\": \"65\"}]";
}
