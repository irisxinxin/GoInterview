package com.irisxinxin.projectdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.irisxinxin.projectdemo.mapper")//将mapper管理起来

public class ProjectDemoApplication {
    //启动类
    public static void main(String[] args) {
        SpringApplication.run(ProjectDemoApplication.class, args);
    }

}
