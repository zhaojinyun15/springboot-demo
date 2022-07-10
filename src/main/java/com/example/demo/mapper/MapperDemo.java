package com.example.demo.mapper;

import com.example.demo.model.Test1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapperDemo {
    int insertTest1(Test1 test1);


}
