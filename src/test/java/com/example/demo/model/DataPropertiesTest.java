package com.example.demo.model;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DataPropertiesTest {
    @Autowired
    private DataProperties dataProperties;

    @Test
    public void varTest() {
        Map<String, String> data = dataProperties.getData();
        log.debug("{}", data);
    }
}
