package com.irisxinxin.projectdemo.mapper;

import com.irisxinxin.projectdemo.entity.TUser;
import org.springframework.stereotype.Component;


public interface TUserMapper {

    public TUser selectByPrimaryKey(Integer i);

}
