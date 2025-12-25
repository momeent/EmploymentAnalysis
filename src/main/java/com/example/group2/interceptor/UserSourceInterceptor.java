package com.example.group2.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.group2.util.Result;
import com.example.group2.util.TokenUtil;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * user source拦截器,拦截对于Users文件夹下图片等资源的访问。对请求者的身份进行校验
 */
@Component
public class UserSourceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("UserSourcePreHandle----");
        String url=request.getRequestURL().toString();
        System.out.println("source url: "+url);

        //处理非简单请求跨域
        //blog.csdn.net/qq_39007083/article/details/103582232
        //https://blog.csdn.net/qq_39007083/article/details/103574845
        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Max-Age","3600");

        String token=request.getHeader("token");
        if(StringUtils.isNullOrEmpty(token)) {//没有token
            Result error=Result.error("Source: NOT-LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));//在response中放入错误信息
            System.out.println("Source: NOT-LOGIN");
            return false;//阻止请求
        }
        System.out.println("Source: -----token: "+token+" -----");
        try{
            Result result= TokenUtil.verify(token);
            if(result.getResultCode()==Result.FAIL) {//token过期或错误
                response.getWriter().write(JSONObject.toJSONString(result));//在response中放入错误信息
                System.out.println(result.getMessage());
                return false;
            }
            else {//验证成功
                System.out.println("Source: token有效");
                DecodedJWT jwt=(DecodedJWT) result.getData();
                String userId=jwt.getClaim("userId").toString();
                String urlId=url.substring(url.indexOf("Users")).split("/")[1];
                if(urlId.equals(userId)) {
                    System.out.println("Source: 发放资源");
                    return true;//请求的是自己的资源
                }else {
                    System.out.println("Source: 他人资源，拒绝发放");
                    return false;//请求的不是自己的资源
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
