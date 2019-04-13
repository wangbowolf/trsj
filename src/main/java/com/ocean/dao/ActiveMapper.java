package com.ocean.dao;

import com.ocean.pojo.Active;

import java.util.List;

public interface ActiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Active record);

    int insertSelective(Active record);

    Active selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Active record);

    int updateByPrimaryKey(Active record);

    List<Active> listActiveAll(String title, String location);

    int listActiveAllCount(String title, String location);
}