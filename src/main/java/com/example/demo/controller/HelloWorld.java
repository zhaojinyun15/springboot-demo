package com.example.demo.controller;

import com.example.demo.model.Test1;
import com.example.demo.service.ServiceDemo;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloWorld {
    @Autowired
    private ServiceDemo serviceDemo;

    @RequestMapping("/helloworld")   // http://localhost:8080/hello/helloworld
    public String helloWorld() {
        return "hello world!!!";
    }

    @RequestMapping("/insert")   // http://localhost:8080/hello/insert?a=xxx&b=xxx&c=xxx
    public Result insertTest1(String a, String b, String c) {
        Test1 test1 = new Test1(a, b, c);
        return serviceDemo.insertTest1(test1);
    }

    @GetMapping("/select")   // http://localhost:8080/hello/select?id=xxx
    public Result selectTest1(Integer id) {
        return serviceDemo.selectTest1(id);
    }
}
