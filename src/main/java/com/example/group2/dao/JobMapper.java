package com.example.group2.dao;

import com.example.group2.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobMapper {

    /**
     * 得到职位  所有职位数据全部返回
     * @return
     */
    @Select("SELECT * FROM careercrafthub.job_data;")
    public List<Job> getJobList();
}
