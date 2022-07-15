package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class HelloWorldTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void selectTest1Test() {
        Result result = helloWorld.selectTest1(5);
        log.debug("result is: {}", result);
    }
}
