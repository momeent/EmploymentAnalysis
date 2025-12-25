package com.example.group2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Group2Application {

    public static void main(String[] args) {
        SpringApplication.run(Group2Application.class, args);
    }

}
