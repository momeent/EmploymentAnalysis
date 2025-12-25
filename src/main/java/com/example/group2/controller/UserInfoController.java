package com.example.group2.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.group2.entity.ChangeableUserInfoEntity;
import com.example.group2.entity.User;
import com.example.group2.service.Impl.JSONServiceImpl;
import com.example.group2.service.JSONService;
import com.example.group2.service.PythonService;
import com.example.group2.service.UserService;
import com.example.group2.util.Result;
import com.example.group2.util.Resume;
import com.example.group2.util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin
public class UserInfoController {
    @Autowired
    UserService userService;
    @Autowired
    JSONService jsonService;

    @Autowired
    PythonService pythonService;

    /**
     * 用户上传头像,保存并更新数据库
     *
     * @param request 用于提取token，取得userId
     * @param file    头像文件
     */
    @PostMapping("/uploadAvatar")
    public Result uploadAvatar(HttpServletRequest request,
                               MultipartFile file) throws IOException {
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        String userId = String.valueOf(jwt.getClaim("userId"));
        String directory = "\\Users\\" + userId + "\\avatar\\";

        //get the original file name
        String originalClothName = file.getOriginalFilename();

        //create the unique file name
        String extname = originalClothName.substring(originalClothName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + extname;

        //get the absolute path
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String prefix = applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "\\src\\main\\resources";

        File dir = new File(prefix + directory);
        //取得这个目录下的所有子文件对象
        File[] files = dir.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            f.delete();
        }

        //save the file
        file.transferTo(new File(prefix + directory + newName));

        if (userService.uploadAvatar(Integer.parseInt(userId), newName)) return Result.success(newName);
        return Result.error("更新头像失败");
    }

    /**
     * 更新简历信息
     * @param request 用于提取token，取得userId
     * @param jsonObject 简历对象
//     * @param userId 用户id  后面来改
     * @return
     */
    @PostMapping("/updateResume")
    public Result updateResume(HttpServletRequest request, @RequestBody JSONObject jsonObject){
        String token = request.getHeader("token");
        DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
        int userId = Integer.parseInt(String.valueOf(jwt.getClaim("userId")));
        System.out.println("接收成功");
        System.out.println(jsonObject);
        jsonService.updateResume(jsonObject, userId);
        return Result.success();
    }

    @GetMapping("/downloadResume")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            String token = request.getHeader("token");
            DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
            int userId = Integer.parseInt(String.valueOf(jwt.getClaim("userId")));

            pythonService.getResumePdf(userId);

            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            String prefix = applicationHome.getDir().getParentFile()
                    .getParentFile().getAbsolutePath() + "\\src\\main\\resources";
            // 获取文件路径，这里假设文件在项目根目录下的"files"文件夹中
            String filePath = prefix + "\\Users\\" + userId + "\\resume"+ ".pdf";

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
            } catch (Exception e) {
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

    @PostMapping("/updateBasicInfo")
    public Result updateBasicInfo(
            HttpServletRequest request,
            @RequestBody User user ){
        try {
            String token = request.getHeader("token");
            DecodedJWT jwt = (DecodedJWT) TokenUtil.verify(token).getData();
            int userId = Integer.parseInt(String.valueOf(jwt.getClaim("userId")));

            System.out.println("----------basic info:---------------");
            System.out.println(user);

            if(userId!=user.getUserId()) return Result.error("update error");
            userService.updateBasicInfo(user);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("update error");
        }
        return Result.success();
    }
}
