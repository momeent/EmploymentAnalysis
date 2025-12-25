package com.example.group2.config;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //get the absolute path
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String prefix=applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "\\src\\main\\resources";
        // map the path ( local path <-----> virtual directory on server )
        registry.addResourceHandler("/statics/**")
                .addResourceLocations("file:"+prefix+"\\statics/");
        registry.addResourceHandler("/Users/**")
                .addResourceLocations("file:"+prefix+"\\Users/");
        registry.addResourceHandler("/jobs/**")
                .addResourceLocations("file:"+prefix+"\\jobs/");
    }
}

