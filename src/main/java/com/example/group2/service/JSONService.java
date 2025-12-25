package com.example.group2.service;


import com.alibaba.fastjson.JSONObject;
import com.example.group2.entity.User;
import com.example.group2.util.Resume;

public interface JSONService {
    /**
     * 根据用户的电话号码，新建一个Json文件
     * @param user  用户信息
     * @return 返回简历文件对应的JSONObject
     */
    public JSONObject createJson(User user);

    public JSONObject fileToJson(String fileName);

    /**
     * 更新简历json
     * @param resume 简历对象
     * @param userId 用户id
     */
    void updateResume(JSONObject jsonObject, int userId);
}
