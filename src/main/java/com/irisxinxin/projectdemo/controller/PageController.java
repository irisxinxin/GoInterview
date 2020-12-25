package com.irisxinxin.projectdemo.controller;

import com.irisxinxin.projectdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("hello")
    public String hello(Model model) {
        //1. 携带数据
        model.addAttribute("username", "iris");
        // 2. 携带自定义对象
        User user = new User(1, "iris", new Date());
        model.addAttribute("user", user);
        return "hello";
    }



}
