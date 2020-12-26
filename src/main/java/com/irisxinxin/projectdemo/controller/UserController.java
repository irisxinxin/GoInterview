package com.irisxinxin.projectdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irisxinxin.projectdemo.config.Resource;
import com.irisxinxin.projectdemo.entity.TUser;
import com.irisxinxin.projectdemo.entity.User;
import com.irisxinxin.projectdemo.pojo.ResultBean;
import com.irisxinxin.projectdemo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
@Slf4j
public class   UserController {

    @Autowired
    private Resource resource;

    @Autowired
    private IUserService userService;


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
    public TUser getById2(@PathVariable("id") Integer id) {
        System.out.println("id="+id);
        System.out.println("查询操作");
        return userService.getById(id);
    }


    @PostMapping("add")
    public ResultBean add(@Valid User user) {
        // 1. AOP 将核心业务逻辑和非核心业务逻辑分离
        System.out.println(user.getId());
        return new ResultBean("ok", "200");
    }

    @GetMapping("getImageServer")
    public String getImageServer() {
        return resource.getImageServer();
    }



}
