package com.example.demo.service;

import com.example.demo.model.MyCron;
import org.springframework.stereotype.Service;

@Service
public interface CronService {
    void start();

    void update(MyCron myCron);
}
