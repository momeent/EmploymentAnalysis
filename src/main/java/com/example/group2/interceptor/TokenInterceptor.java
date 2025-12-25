package com.example.group2.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.group2.util.Result;
import com.example.group2.util.TokenUtil;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * token interceptor 每次请求controller时验证请求头中是否有token、token是否正确
 * 拦截所有请求，除了/login
 *
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    //目标资源运行前运行，返回true，放行，返回false，不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TokenPreHandle---- "+request.getRequestURL());
        //处理非简单请求跨域
        //blog.csdn.net/qq_39007083/article/details/103582232
        //https://blog.csdn.net/qq_39007083/article/details/103574845
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Max-Age","3600");

        String token=request.getHeader("token");
        if(StringUtils.isNullOrEmpty(token)) {
            Result error=Result.error("Token: NOT-LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));//在response中放入错误信息
            System.out.println("Token: NOT-LOGIN");
            return false;//阻止请求
        }
        System.out.println("Token: -----token: "+token+" -----");
        try{
            Result result= TokenUtil.verify(token);
            if(result.getResultCode()==Result.FAIL) {//token过期或错误
                response.getWriter().write(JSONObject.toJSONString(result));//在response中放入错误信息
                System.out.println(result.getMessage());
                return false;
            }
            else {//验证成功
                System.out.println("Token: verify success");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
