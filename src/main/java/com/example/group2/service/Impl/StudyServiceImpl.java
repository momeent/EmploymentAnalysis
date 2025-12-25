package com.example.group2.service.Impl;

import com.example.group2.dao.StudyMapper;
import com.example.group2.entity.Study;
import com.example.group2.service.StudyService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    StudyMapper studyMapper;

    @Override
    public List<Study> getByType(String type) {
        List<Study> studies = studyMapper.getByType(type);
        System.out.println(studies);
        return studies;
    }

    @Override
    public List<Study> getHot() {
        List<Study> hot = studyMapper.getHot();
        return hot;
    }

    @Override
    public String[] getTypes(String type) {
        String[] types = studyMapper.getTypes(type);
        return types;
    }
}
