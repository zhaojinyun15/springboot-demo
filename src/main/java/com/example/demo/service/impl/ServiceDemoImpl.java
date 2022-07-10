package com.example.demo.service.impl;

import com.example.demo.mapper.MapperDemo;
import com.example.demo.model.Test1;
import com.example.demo.service.ServiceDemo;
import com.example.demo.util.Result;
import com.example.demo.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        log.info("id = {}", newId);
        Result<Integer> result = ResultVo.success(newId, false);
        return result;
    }

    @Override
    @Transactional
    public Result deleteTest1() {
        return null;
    }

    @Override
    @Transactional
    public Result updateTest1() {
        return null;
    }

    @Override
    public Result selectTest1() {
        return null;
    }
}