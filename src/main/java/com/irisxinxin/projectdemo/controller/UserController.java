package com.irisxinxin.projectdemo.controller;

import com.irisxinxin.projectdemo.config.Resource;
import com.irisxinxin.projectdemo.entity.TUser;
import com.irisxinxin.projectdemo.entity.User;
import com.irisxinxin.projectdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
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
    public String add(User user) {
        System.out.println(user.getId());
        return "ok";
    }

    @GetMapping("getImageServer")
    public String getImageServer() {
        return resource.getImageServer();
    }



}
