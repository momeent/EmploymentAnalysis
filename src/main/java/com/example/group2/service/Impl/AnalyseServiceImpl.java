package com.example.group2.service.Impl;

import com.example.group2.service.AnalyseService;
import com.example.group2.service.PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AnalyseServiceImpl implements AnalyseService {
    @Autowired
    PythonService pythonService;




    @Override
    public String getResumeAnalyse(int userId) throws IOException {
        //首先得到简历路径
        String rootPath = System.getProperty("user.dir");   //根路径
        String resumePath = rootPath+"\\src\\main\\resources\\Users\\" + userId + "\\resume" + userId + ".json";

//        //将json简历转为字符串
//        byte[] bytes = Files.readAllBytes(path);
//        String resume = new String(bytes);

        //调用python方法
        String resumeAnalyse = pythonService.communicate("下面是一份json格式的简历，请对这个简历进行评价和分析:", resumePath);

        return resumeAnalyse;
    }

    @Override
    public String getCareerGuidance(int userId) throws IOException {
        //首先得到简历路径
        String rootPath = System.getProperty("user.dir");   //根路径
        String resumePath = rootPath+"\\src\\main\\resources\\Users\\" + userId + "\\resume" + userId + ".json";
        Path path = Paths.get(resumePath);

        //调用python方法
        String careerGuidance = pythonService.communicate("下面是一份json格式的简历，请给出一份就业指导:" , resumePath);

        return careerGuidance;
    }

    /**
     * 学习指导
     * @param userId 用户id
     * @return
     */
    @Override
    public String getLearningGuidance(int userId) throws IOException {
        //首先得到简历路径
        String rootPath = System.getProperty("user.dir");   //根路径
        String resumePath = rootPath+"\\src\\main\\resources\\Users\\" + userId + "\\resume" + userId + ".json";
        Path path = Paths.get(resumePath);

        //调用python方法
        String learningGuidance = pythonService.communicate("下面是一份json格式的简历，请给出一份学习指导:" ,resumePath);

        return learningGuidance;
    }

    @Override
    public String getScore(int userId) throws IOException {
        //首先得到简历路径
        String rootPath = System.getProperty("user.dir");   //根路径
        String resumePath = rootPath+"\\src\\main\\resources\\Users\\" + userId + "\\resume" + userId + ".json";

        //调用python方法
        String scoreString = pythonService.communicate("下面是一份json格式的简历，请根据这份简历的能力进行评价，但是请记住，你必须仅给出一个0-100之间的分数:" ,resumePath);

        //在得到的scoreString中提取分数
        // 定义正则表达式模式
        Pattern pattern = Pattern.compile("\\d+");

        // 使用Matcher查找匹配项
        Matcher matcher = pattern.matcher(scoreString);

        String number = "83";
        int count = 0;
        while (matcher.find() && count < 2) {
             number = matcher.group();
            count++;
        }
        // 判断num是否符合逻辑
        int num;
        if(Integer.parseInt(number) > 60 && Integer.parseInt(number) < 100){
            System.out.println("number:"+ number);
            System.out.println("scoreString:"+scoreString);

            return number;
        }
        else{
            return "83";
        }

    }
}
