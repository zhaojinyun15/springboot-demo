package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class HelloWorldTest {

    @Autowired
    private HelloWorld helloWorld;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void selectTest1Test(Integer id) {
        Result result = helloWorld.selectTest1(id);
        log.debug("result is: {}", result);
    }
}
