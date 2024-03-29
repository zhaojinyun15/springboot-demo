package com.example.demo.service.impl;

import com.example.demo.mapper.MapperDemo;
import com.example.demo.model.Test1;
import com.example.demo.service.ServiceDemo;
import com.example.demo.util.Result;
import com.example.demo.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ServiceDemoImpl implements ServiceDemo {

    @Autowired
    private MapperDemo mapperDemo;

    @Override
    @Transactional
    public Result insertTest1(Test1 test1) {
        int i = mapperDemo.insertTest1(test1);
        Integer newId = test1.getId();
        log.debug("id = {}", newId);
        Result<Integer> result = ResultVo.success(newId, false);
        return result;
    }

    @Override
    @Transactional
    public Result deleteTest1(Integer id) {
        int i = mapperDemo.deleteTest1(id);
        log.debug("delete row number: {}", i);
        Result<Object> result = ResultVo.success(null, false);
        return result;
    }

    @Override
    @Transactional
    public Result updateTest1(Test1 test1) {
        int i = mapperDemo.updateTest1(test1);
        log.debug("update row number: {}", i);
        Result<Object> result = ResultVo.success(null, false);
        return result;
    }

    @Override
    public Result selectTest1(Integer id) {
        List<Test1> test1List = mapperDemo.selectTest1(id);
        log.debug("query by id={}, result is {}", id, test1List);
        Result<List<Test1>> result = ResultVo.success(test1List, false);
        return result;
    }

    @Override
    public Result logThreadTest1(String threadName) {
        log.info("main thread");
        MDC.put("threadName", threadName);
        log.info("sub thread, threadName is: {}", threadName);
        MDC.remove("threadName");
        return ResultVo.success(threadName, true);
    }
}
