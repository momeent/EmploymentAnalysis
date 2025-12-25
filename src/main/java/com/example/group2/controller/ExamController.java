package com.example.group2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.group2.service.ExamService;
import com.example.group2.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@Slf4j
@CrossOrigin
public class ExamController {
    @Autowired
    ExamService examService;

    @GetMapping("/getExam")
    public Result getExam(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PublicServants", examService.getExam("公务员"));
        jsonObject.put("TeacherQualifications", examService.getExam("教师资格"));
        jsonObject.put("SoftTest", examService.getExam("软考"));
        return Result.success(jsonObject);

    }

    @GetMapping("/downloadExam")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String pdf) {
        try {
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            String prefix = applicationHome.getDir().getParentFile()
                    .getParentFile().getAbsolutePath() + "\\src\\main\\resources\\pdfs\\";
            // 获取文件路径
            String filePath = prefix + pdf;

            File file = new File(filePath);
            BufferedInputStream bis = null;
            OutputStream os = null;
            FileInputStream fileInputStream = null;
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=EncryptPDF");
            try {
                fileInputStream = new FileInputStream(file);
                byte[] buff = new byte[1024];
                bis = new BufferedInputStream(fileInputStream);
                os = response.getOutputStream();

                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    i = bis.read(buff);
                    os.flush();
                }
                os.flush();
                os.close();
//                return SimpleResult.ok("导出成功",os);
//                return Result.success(os);
            } catch (IOException e) {
                e.printStackTrace();
//                return SimpleResult.fail("导出失败",null);
//                return Result.error("导出失败");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
//                        return SimpleResult.fail("导出失败",null);
//                        return Result.error("导出失败");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            return Result.error("导出失败");
        }
    }
}
