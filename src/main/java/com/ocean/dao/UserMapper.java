package com.ocean.dao;

import com.ocean.pojo.User;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/7 0007 02:16
 * @Version 1.0
 **/
public interface UserMapper{

    int insert(User user);

    User getUser(String phone);

    void addUserInPhone(String phone);
}
