package com.simple.entity.response;

import java.util.ArrayList;
import java.util.List;

public class VehicleResponse<T> {
    
    private List<String> errors = new ArrayList<String>();

    private T object;
    
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}