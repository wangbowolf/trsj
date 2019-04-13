package com.ocean.service;

import com.ocean.pojo.Active;

import java.util.List;

public interface ActiveService {

    //活动发布
    int addActivePublish(Active active);

    //活动修改
    int updateActive(Active active);

    //获取活动页
    List<Active> listActiveAllByPage(int currentPage, int pageSize, String title, String location);

}
