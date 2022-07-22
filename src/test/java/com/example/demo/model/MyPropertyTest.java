package com.example.demo.model;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class MyPropertyTest {
    @Autowired
    private MyProperty myProperty;

    @Test
    public void varTest() {
        String propertyOne = myProperty.propertyOne;
        String propertyTwo = myProperty.propertyTwo;
        log.debug("propertyOne: {}", propertyOne);
        log.debug("propertyTwo: {}", propertyTwo);
    }
}
