package com.example.group2.config;

import com.example.group2.interceptor.TokenInterceptor;
import com.example.group2.interceptor.UserSourceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Autowired
    private UserSourceInterceptor userSourceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/statics/**")
                .excludePathPatterns("/Users/**")
                .excludePathPatterns("/sendcode")
                .excludePathPatterns("/register")
                .excludePathPatterns("/jobList");
        registry.addInterceptor(userSourceInterceptor)
                .addPathPatterns("/Users/**");
    }
}
