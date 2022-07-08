package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping("/helloworld")   // http://localhost:8080/hello/helloworld
    public String helloWorld() {
        return "hello world!!!";
    }
}
