package com.example.group2.dao;

import com.example.group2.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamMapper {
    @Select("select category, exam_date, pdf_name, type from exam where type=#{type}")
    @Results({
            @Result(property = "examDate",column = "exam_date"),
            @Result(property = "pdf_name", column = "pdfName")
    })
    List<Exam> getExam(String type);
}
