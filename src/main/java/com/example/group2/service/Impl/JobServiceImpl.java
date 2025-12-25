package com.example.group2.service.Impl;

import com.example.group2.dao.JobMapper;
import com.example.group2.entity.Job;
import com.example.group2.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;
    @Override
    public List<Job> getJobList() {
        List<Job> jobList = jobMapper.getJobList();
        return jobList;
    }
}
