package com.example.group2.controller;

//import com.alibaba.fastjson.JSONObject;
//import net.sf.json.JSONObject;
import com.example.group2.service.JSONService;
import com.example.group2.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主要功能为返回详情页面的信息文件（jobDetails, studyDetails）
 * 返回服务端的json文件，文件中包含页面的内容信息
 */
@RestController
@Slf4j
@CrossOrigin
public class DetailController {
    @Autowired
    JSONService jsonService;

    /**
     * 前端页面访问岗位详情页面时，发送请求。此controller接收请求后返回页面详情信息。
     * @param request 对页面详情的get请求
     * @return Result中包含jsonObject，内含页面详情信息
     */
    @GetMapping("/jobDetail")
    public Result jobDetail(HttpServletRequest request){
        com.alibaba.fastjson.JSONObject jsonObject=
                jsonService.fileToJson("E:\\E.Desktop\\1.json");
        return Result.success(jsonObject);
    }
}
