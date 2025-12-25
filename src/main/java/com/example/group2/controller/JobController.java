package com.example.group2.controller;

import com.example.group2.entity.Job;
import com.example.group2.service.JobService;
import com.example.group2.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class JobController {

    @Autowired
    JobService jobService;

    /**
     * 得到所有求职数据
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/jobList")
    public Result getJobList(HttpServletRequest request, HttpServletResponse response){
        List<Job> jobList = jobService.getJobList();
        return Result.success(jobList);
    }

}
