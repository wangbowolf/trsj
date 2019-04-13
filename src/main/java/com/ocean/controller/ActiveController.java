package com.ocean.controller;

import com.alibaba.fastjson.JSONObject;
import com.ocean.annotation.UserLoginToken;
import com.ocean.pojo.Active;
import com.ocean.pojo.ResponseBo;
import com.ocean.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ActiveController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/13 0013 18:00
 * @Version 1.0
 **/
@RestController
@UserLoginToken
public class ActiveController {

    @Autowired
    private ActiveService activeService;

    //活动发布
    @PostMapping("active")
    public ResponseBo addActivePublish(@RequestBody Active active){
        int i = activeService.addActivePublish(active);
        if(i > 0){
            return ResponseBo.success();
        }
        return ResponseBo.fail();
    }

    //活动修改
    @PutMapping("active/{id}")
    public ResponseBo updateActive(@RequestBody Active active, @PathVariable Integer id){
        active.setId(id);
        int m = activeService.updateActive(active);
        if(m > 0){
            return ResponseBo.success();
        }
        return ResponseBo.fail();
    }

    //活动查询(全部)
    @GetMapping("actives")
    public JSONObject listActivesBySerch(@RequestParam(required = false) int currentPage,
                                         @RequestParam(required = false) int pageSize,
                                         @RequestParam(required = false) String title,
                                         @RequestParam(required = false) String location){
        List<Active> actives = activeService.listActiveAllByPage(currentPage, pageSize, title, location);
        return ResponseBo.returnData(actives);
    }

}
