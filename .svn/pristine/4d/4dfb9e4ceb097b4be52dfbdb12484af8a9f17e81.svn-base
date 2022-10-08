package com.gcsj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String  filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\avatar\\";
        registry.addResourceHandler("/avatar/**").addResourceLocations("file:"+filePath+"/");

    }
}
