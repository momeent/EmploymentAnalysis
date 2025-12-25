package com.example.group2.service;

/**
 * 把有关python的代码都放这里
 */
public interface PythonService {

    /**
     * 调用文心一言
     * @param s 提问的字符串
     * @return 返回回答
     */
    String communicate(String s, String path);

    /**
     * 根据json文件路径  生成pdf，无返回
     * @param userId  用户id（即简历）
     */
    void getResumePdf(int userId);
}
