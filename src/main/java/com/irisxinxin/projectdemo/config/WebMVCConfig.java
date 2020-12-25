package com.irisxinxin.projectdemo.config;

import com.irisxinxin.projectdemo.interceptor.MyInterceptpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptpr myInterceptpr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器配置
        // new 出的东西不归spring管理
        registry.addInterceptor(myInterceptpr).addPathPatterns("/*");

    }
}
