package com.example.group2.controller;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.group2.service.AnalyseService;
import com.example.group2.util.Result;
import com.example.group2.util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@CrossOrigin
public class AnalyseController {

    @Autowired
    AnalyseService analyseService;


    /**
     * 根据用户id得到：简历分析，就业指导，学习指导
     * @param request
     * @param response
     * @return  返回JSONObject 放三个字符串
     */
    @GetMapping("/generateResumeAnalysis")
    public Result analyse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        String userIdStr = String.valueOf(jwt.getClaim("userId"));
        int userId = Integer.parseInt(userIdStr);

        String resumeAnalyse = analyseService.getResumeAnalyse(userId);
        String careerGuidance = analyseService.getCareerGuidance(userId);
        String learningGuidance = analyseService.getLearningGuidance(userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resumeAnalyse", resumeAnalyse);
        jsonObject.put("careerGuidance", careerGuidance);
        jsonObject.put("learningGuidance", learningGuidance);

        return Result.success(jsonObject);
    }

    /**
     * 得到简历评分
     */
    @GetMapping("/getScore")
    public Result getScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        String userIdStr = String.valueOf(jwt.getClaim("userId"));
        int userId = Integer.parseInt(userIdStr);

        String score = analyseService.getScore(userId);
        return Result.success(score);
    }

}
