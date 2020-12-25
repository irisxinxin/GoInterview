package com.irisxinxin.projectdemo.interceptor;

import com.irisxinxin.projectdemo.config.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptpr implements HandlerInterceptor {

    @Autowired
    private Resource resource;
    //预处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(resource.getImageServer());
        System.out.println("拦截器放行");
        return true;
    }
}
