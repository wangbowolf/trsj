package com.ocean.service.impl;

import com.ocean.dao.UserMapper;
import com.ocean.pojo.ResponseBo;
import com.ocean.pojo.User;
import com.ocean.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/7 0007 02:24
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public ResponseBo save(User user) {
        if(userMapper.insert(user) > 0){
            return ResponseBo.ok();
        }
        return ResponseBo.fail();
    }

    @Override
    public User getUser(String phone) {
        return userMapper.getUser(phone);
    }

    @Override
    public void addUserInPhone(String phone) {
        userMapper.addUserInPhone(phone);
    }
}
