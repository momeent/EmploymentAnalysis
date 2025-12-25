package com.example.group2.service;

import java.io.IOException;

public interface AnalyseService {
    /**
     * 根据userId获取简历，得到简历分析
     * @param userId 用户id
     * @return 返回字符串  简历分析
     */
    String getResumeAnalyse(int userId) throws IOException;

    /**
     * 根据userId获取简历，得到职业指导
     * @param userId 用户id
     * @return 返回字符串  职业指导
     */
    String getCareerGuidance(int userId) throws IOException;


    /**
     * 根据userId获取简历，得到学习指导
     * @param userId 用户id
     * @return 返回字符串  学习指导
     */
    String getLearningGuidance(int userId) throws IOException;

    /**
     * 根据userId获取简历，得到评分分数
     * @param userId
     * @return
     * @throws IOException
     */
    String getScore(int userId) throws IOException;
}
