package com.example.demo.mapper;

import com.example.demo.DemoApplication;
import com.example.demo.model.Test1;
import com.example.demo.model.TestP;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void selectTest1Test() {
        Integer id = 1;
        List<Test1> test1List = mapper.selectTest1(id);
        for (Test1 test1 : test1List) {
            log.debug("test1: {}", test1);
        }
    }

    @Test
    void selectTestPTest() {
        Integer id = 1;
        List<TestP> testPList = mapper.selectTestP(id);
        for (TestP testP : testPList) {
            log.info("{}", testP);
        }
    }
}
