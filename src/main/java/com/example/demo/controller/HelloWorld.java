package com.example.demo.controller;

import com.example.demo.model.Test1;
import com.example.demo.service.ServiceDemo;
import com.example.demo.util.Result;
import com.example.demo.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insert")   // http://localhost:8080/hello/insert
    public Result insertTest1(@RequestBody Test1 test1) {
        log.debug("insertTest1's post body: {}", test1);
        return serviceDemo.insertTest1(test1);
    }

    @GetMapping("/delete")   // http://localhost:8080/hello/delete?id=xxx
    public Result deleteTest1(Integer id) {
        log.debug("deleteTest1's params id: {}", id);
        if (id == null) {
            return ResultVo.error("id could not be null", "1");
        }
        return serviceDemo.deleteTest1(id);
    }

    @PostMapping("/update")   // http://localhost:8080/hello/update
    public Result updateTest1(@RequestBody Test1 test1) {
        log.debug("insertTest1's post body: {}", test1);
        if (test1.getId() == null) {
            return ResultVo.error("id could not be null", "1");
        }
        return serviceDemo.updateTest1(test1);
    }

    @GetMapping("/select")   // http://localhost:8080/hello/select?id=xxx
    public Result selectTest1(Integer id) {
        log.debug("selectTest1's params: {}", id);
        return serviceDemo.selectTest1(id);
    }
}
