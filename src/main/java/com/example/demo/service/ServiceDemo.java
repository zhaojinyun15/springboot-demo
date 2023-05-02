package com.example.demo.service;

import com.example.demo.model.Test1;
import com.example.demo.util.Result;
import org.springframework.stereotype.Service;

@Service
public interface ServiceDemo {
    Result insertTest1(Test1 test1);
    Result deleteTest1(Integer id);
    Result updateTest1(Test1 test1);
    Result selectTest1(Integer id);

    Result logThreadTest1(String threadName);
}
