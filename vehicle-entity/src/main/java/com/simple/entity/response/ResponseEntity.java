package com.simple.entity.response;

import java.util.ArrayList;
import java.util.List;

public abstract class ResponseEntity {
    
    private List<String> errors = new ArrayList<String>();

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}