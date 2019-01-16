package com.sinovatech.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Model {

    @Value("${modelName}")
    private String modelName;

    public void print() {
        System.out.println(modelName);
    }

}
