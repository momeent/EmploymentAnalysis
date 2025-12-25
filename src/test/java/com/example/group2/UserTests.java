package com.example.group2;

import com.example.group2.entity.User;
import com.example.group2.service.UserService;
import com.example.group2.util.Resume;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class UserTests {

    @Test
    void serviceFindUser(){
    }
    @Test
    void testJson(){
        User user=new User();
        user.setUserPhone("123123");
        Resume resume=new Resume();
        resume.setTel(user.getUserPhone());
    }
}
