package com.example.group2.service.Impl;

import com.example.group2.dao.ExamMapper;
import com.example.group2.entity.Exam;
import com.example.group2.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamMapper examMapper;

    @Override
    public List<Exam> getExam(String type) {
        List<Exam> exams = examMapper.getExam(type);
        return exams;
    }
}
