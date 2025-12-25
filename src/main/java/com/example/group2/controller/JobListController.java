package com.example.group2.controller;


import com.example.group2.Common.common;
import com.example.group2.util.JobItem;
import com.example.group2.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class JobListController {
//    @GetMapping("/jobList")

    public Result jobList(HttpServletRequest request, HttpServletResponse response){
        JobItem[] jobItems=new JobItem[common.ONCE_JOB_NUM];
        for(int i=0;i<common.ONCE_JOB_NUM;i++){
            jobItems[i]=new JobItem(i,"title: "+i,
                    "description: ------"+i+"------","www.baidu.com");
        }
        return Result.success(jobItems);
    }
}
