package com.example.demo.mapper;

import com.example.demo.model.Test1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapperDemo {
    int insertTest1(Test1 test1);

    int deleteTest1(Integer id);

    int updateTest1(Test1 test1);

    List<Test1> selectTest1(Integer id);
}
