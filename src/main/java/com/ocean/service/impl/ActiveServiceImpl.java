package com.ocean.service.impl;

import com.github.pagehelper.PageHelper;
import com.ocean.dao.ActiveMapper;
import com.ocean.pojo.Active;
import com.ocean.service.ActiveService;
import com.ocean.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ActiveServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/13 0013 18:00
 * @Version 1.0
 **/
@Service("activeService")
public class ActiveServiceImpl implements ActiveService {

    @Resource
    private ActiveMapper activeMapper;

    @Override
    public int addActivePublish(Active active) {
        return activeMapper.insert(active);
    }

    @Override
    public int updateActive(Active active) {
        return activeMapper.updateByPrimaryKeySelective(active);
    }

    @Override
    public List<Active> listActiveAllByPage(int currentPage, int pageSize, String title, String location) {
        PageHelper.startPage(currentPage, pageSize);
        List<Active> actives = activeMapper.listActiveAll(title, location);
        int count = activeMapper.listActiveAllCount(title, location);
        PageBean<Active> objectPageBean = new PageBean<>(currentPage, pageSize, count);
        objectPageBean.setItems(actives);
        return objectPageBean.getItems();
    }
}
