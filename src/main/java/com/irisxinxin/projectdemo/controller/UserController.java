package com.irisxinxin.projectdemo.controller;

import com.irisxinxin.projectdemo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {


    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("del")
    public String getById() {
        System.out.println("查询操作");
        return "ok";
    }

    @GetMapping("{id}")
    public User getById2(@PathVariable("id") Long id) {
        return new User(id, "iris", new Date());
    }


}
