package com.irisxinxin.projectdemo.service.imp;

import com.irisxinxin.projectdemo.entity.TUser;
import com.irisxinxin.projectdemo.mapper.TUserMapper;
import com.irisxinxin.projectdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
