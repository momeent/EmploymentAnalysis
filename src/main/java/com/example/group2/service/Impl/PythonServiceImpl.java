package com.example.group2.service.Impl;

import com.example.group2.service.PythonService;
import com.example.group2.util.Project;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * python代码
 */
@Service
public class PythonServiceImpl implements PythonService {

    //python路径
    String rootPath = System.getProperty("user.dir");   //根路径  F:\hjh\XJTU
    String gptDemoPath = rootPath+"\\python\\gptdemo.py";
    String getResumePath = rootPath+"\\python\\ResumeGeneration.py";


    /**
     * 调用python进行分析
     * @param s 提问的字符串
     * @return 返回文心一言的回答
     */
    @Override
    public String communicate(String s, String path) {
        Process proc;
        try{
            proc = Runtime.getRuntime().exec("python "+gptDemoPath +" "+ s +" "+ path);
            //输入输出流来截取结果
            InputStreamReader isr =  new InputStreamReader(proc.getInputStream(),"gb2312");
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            String ans = "";
            while((line = in.readLine()) != null){
                ans = ans +"/n"+ line;
            }
            in.close();
            proc.waitFor();
            System.out.println("ans:");
            System.out.println(ans);
//            String str=ans.toString();
//            System.out.println(str);
            return ans;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getResumePdf(int userId) {
        System.out.println("rootpath:"+ rootPath);
        System.out.println("getResumePdf!");
        Process proc;
        try {
            // 设置Python脚本路径和传递的参数
            String[] pythonCommand = {"python", getResumePath, String.valueOf(userId)};

            // 创建ProcessBuilder对象并设置命令
            ProcessBuilder processBuilder = new ProcessBuilder("python",getResumePath);

            processBuilder.command().add(String.valueOf(userId));
            // 启动进程
            Process process = processBuilder.start();
            InputStreamReader isr =  new InputStreamReader(process.getInputStream(),"gb2312");
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            while((line = in.readLine()) != null){
                System.out.println(line);;
            }
            in.close();


            // 等待进程执行完毕
            int exitCode = process.waitFor();

            // 打印进程的退出码
            System.out.println("Python script exited with code: " + exitCode);

//        } catch (IOException | InterruptedException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
