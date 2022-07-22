package com.example.demo.mapper;

import com.example.demo.DemoApplication;
import com.example.demo.model.Test1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class MapperDemoTest {
    @Autowired
    private MapperDemo mapper;

    @Test
    void insertTest1Test() {
        Test1 test1 = new Test1();
        test1.setA("asd");
        test1.setB("qwe");
//        test1.setC("zxc");
        log.debug("test1: {}", test1);
        int i = mapper.insertTest1(test1);
    }
}
