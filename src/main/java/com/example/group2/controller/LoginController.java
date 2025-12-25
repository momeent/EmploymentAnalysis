package com.example.group2.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.example.group2.entity.LoginEntity;
import com.example.group2.entity.SignupForm;
import com.example.group2.entity.UserPhoneEntity;
import com.example.group2.service.JSONService;
import com.example.group2.service.UserService;
import com.example.group2.util.Result;
import com.example.group2.entity.User;
import com.example.group2.util.Resume;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import java.util.Random;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * About SignIn, SignUp
 */
@RestController
@Slf4j
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    JSONService jsonService;

    /**
     * login controller，接收login请求，从数据库中拉取数据确认是否能争取登录
     *
     * @param request     http request
     * @param loginEntity login表格的实体
     * @return result
     */
    @PostMapping("/login")
    public Result login(HttpServletRequest request,
                        @RequestBody LoginEntity loginEntity
    ) {
        //测试用例：id=1，name=111，password=aaaa，phone=111
        System.out.println("loginEntity: " + loginEntity);
        User user = userService.checkLogin(loginEntity);
        if (user != null) {
            //生成token
            String token = userService.generateToken(user);
            //得到用户json文件的路径
            String rootPath = System.getProperty("user.dir");   //根路径
            String path = rootPath+"\\src\\main\\resources\\Users\\" + user.getUserId() + "\\resume" + user.getUserId() + ".json";

            JSONObject resume = jsonService.fileToJson(path);
            System.out.println("resume:"+resume);


            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            jsonObject.put("resume", resume);

            return Result.success(jsonObject);
        } else return Result.error("账号或密码错误");
    }

    @PostMapping("/sendcode")
    public Result sendCode(HttpServletRequest request,
                           @RequestBody UserPhoneEntity userPhoneEntity,
                           HttpSession session) throws Exception {
        try {
            System.out.println("sending code to " + userPhoneEntity.getUserphone() + "~~~~~~~");

            String randNum = new Random().nextInt(1000000) + "";
            Config config = new Config()
                    //这里修改为我们上面生成自己的AccessKey ID
                    .setAccessKeyId("*******")
                    //这里修改为我们上面生成自己的AccessKey Secret
                    .setAccessKeySecret("*******");
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            Client client = new Client(config);
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setSignName("阿里云短信测试")//短信签名
                    .setTemplateCode("SMS_154950909")//短信模板
                    .setPhoneNumbers(userPhoneEntity.getUserphone())//这里填写接受短信的手机号码
                    .setTemplateParam("{\"code\":\"" + randNum + "\"}");//验证码
            // 复制代码运行请自行打印 API 的返回值
            client.sendSms(sendSmsRequest);

            HashMap hashMap = new HashMap<String, Objects>();
            hashMap.put("code", randNum);
//            hashMap.put("code","123456");
            hashMap.put("beginTime", new Date());

            session.setAttribute("code", hashMap);
            session.setMaxInactiveInterval(60);//设置过期时间60s

            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("验证码发送失败");
        }
    }

    /**
     * 验证短信验证码是否有效，有效则进行注册
     *
     * @param request    httprequest
     * @param session    session，从其中取出“code”，code应为一个hashmap，
     *                   其中包含String code，即验证码，以及Date beginTime，即验证码发放时间
     * @param signupForm 注册表单
     * @return Result
     */
    @PostMapping("/register")
    public Result register(HttpServletRequest request,
                           HttpSession session,
                           @RequestBody SignupForm signupForm) {
        System.out.println("ok");
        HashMap sessionCode = (HashMap<String, Objects>) session.getAttribute("code");//从session中取出验证码;
        System.out.println(sessionCode);//[TODO]测试用
        long validTime = 60000L;
        Date date = new Date();
        Date beginTime = (Date) sessionCode.get("beginTime");

        if (sessionCode == null || //session过期被销毁了
                date.compareTo(new Date(beginTime.getTime() + validTime)) > 0) //验证码过期（用户有其他动作可能导致session不被销毁）
            return Result.error("验证码过期");
        else if (sessionCode.get("code").equals(signupForm.getCode())) {//验证码有效,进行注册

            System.out.println("验证码有效");
            User user = userService.addUser(signupForm.getUserphone(),
                    signupForm.getUsername(), signupForm.getPassword());

            // 调用JSONService中的createJson方法，生成一个JSONObject对象
//            User user = new User(1, "123","hhh","786");
            JSONObject resumeJson = jsonService.createJson(user);
            System.out.println("resumeJson: " + resumeJson);

            //生成token，默认登录
            String token = userService.generateToken(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            jsonObject.put("resume", resumeJson);  //在返回值中放入resume
            System.out.println(jsonObject);

            return Result.success(jsonObject);
        } else return Result.error("register failed!");
    }
}
