package com.example.group2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.group2.Common.common;
import com.example.group2.entity.Study;
import com.example.group2.service.StudyService;
import com.example.group2.util.JobItem;
import com.example.group2.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class StudyListController {


    @Autowired
    StudyService studyService;


    /**
     *
     * @param request
     * @param response
     * @param type  大类，中文名称
     * @return
     */
    @GetMapping("/studyList")
    public Result jobList(HttpServletRequest request, HttpServletResponse response,
                          String type){

        // 得到studyList
        List<Study> studies = studyService.getByType(type);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("studyList", studies);

        //得到大类中的所有小类
        String[] types = studyService.getTypes(type);
        jsonObject.put("types", types);
        return Result.success(jsonObject);
    }

    @GetMapping("/hotList")
    public Result hotList(HttpServletRequest request, HttpServletResponse response){
        List<Study> hot = studyService.getHot();
        return Result.success(hot);
    }
}
