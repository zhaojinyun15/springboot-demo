package com.example.demo.service;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class CronServiceTest {
    @Autowired
    private CronService cronService;

    @Test
    public void startTest() {
        cronService.start();
    }
}
