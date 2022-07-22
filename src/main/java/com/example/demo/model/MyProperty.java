package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Data
@Component
public class MyProperty {
    @Value("${property-one}")
    public String propertyOne;
    @Value("${property-two}")
    public String propertyTwo;
}
