package com.example.group2.service;

import com.example.group2.entity.Job;

import java.util.List;

public interface JobService {
    /**
     * 得到职业数据
     * @return
     */
    List<Job> getJobList();
}
