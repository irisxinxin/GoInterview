package com.irisxinxin.projectdemo.controller;

import com.irisxinxin.projectdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("page")
@Slf4j
public class PageController {

    @RequestMapping("hello")
    public String hello(Model model) {
        log.debug("sssss");
        //1. 携带数据
        model.addAttribute("username", "iris");
        // 2. 携带自定义对象
        User user = new User(1, "iris", new Date());
        model.addAttribute("user", user);
        // 3. 条件判断
        model.addAttribute("money", 100000);
        // 集合 && 遍历
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(new User(2, "lily",new Date()));
        model.addAttribute("list", list);
        return "hello";
    }



}
