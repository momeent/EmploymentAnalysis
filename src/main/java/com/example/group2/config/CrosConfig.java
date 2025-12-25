package com.example.group2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executors;

@Configuration
public class CrosConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置跨域请求的域名
                .allowedOriginPatterns("*")
                // 设置是否允许带有 cookie 信息
                .allowCredentials(true)
                // 设置允许的请求方式 put get post head  delete
                .allowedMethods("*")
                .maxAge(3600);
    }

//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
//        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
//        configurer.setDefaultTimeout(30000);
//    }

    // 设置拦截器
//    public void addInterceptors(InterceptorRegistry registry) {
//    @Override
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login","/register",
//                        "/swagger-resources/**", "/webjars/**",
//                        "/v2/**", "/swagger-ui.html/**");
//    }
}


