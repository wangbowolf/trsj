package com.ocean.service;

import com.ocean.pojo.ResponseBo;
import com.ocean.pojo.User;

public interface UserService {

    ResponseBo save(User user);

    User getUser(String phone);

    void addUserInPhone(String phone);

}
