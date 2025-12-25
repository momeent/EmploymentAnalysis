package com.example.group2;

import com.example.group2.service.JSONService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Group2ApplicationTests {
    @Autowired
    JSONService jsonService;

    @Test
    void contextLoads() {
    }
    @Test
    void jsonTest(){
        System.out.println(jsonService.fileToJson("/main/resources/jobs/1.json"));
    }

}
