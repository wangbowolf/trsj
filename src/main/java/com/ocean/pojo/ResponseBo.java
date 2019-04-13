package com.ocean.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @ClassName responseBo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/7 0007 01:01
 * @Version 1.0
 **/
public class ResponseBo extends HashMap<String, Object> {

    // 成功
    private static final Integer SUCCESS = 200;
    // 警告
    private static final Integer WARN = 1;
    // 异常 失败
    private static final Integer FAIL = 500;

    public ResponseBo() {
        put("code", SUCCESS);
        put("msg", "操作成功！");
    }

    public static ResponseBo success() {
        ResponseBo responseBo = new ResponseBo();
        return responseBo;
    }

    public static ResponseBo fail() {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", FAIL);
        responseBo.put("msg", "操作失败，请联系网站管理员！");
        return responseBo;
    }

    public static ResponseBo error(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", FAIL);
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo warn(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", WARN);
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo ok(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", SUCCESS);
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo judge(int code){
        ResponseBo responseBo = new ResponseBo();
        if(code == 1){
            responseBo.put("code", SUCCESS);
            responseBo.put("msg", "操作成功!");
            return responseBo;
        }
        responseBo.put("code", FAIL);
        responseBo.put("msg", "操作失败!请联系管理员!");
        return responseBo;
    }

    public static ResponseBo ok() {
        return new ResponseBo();
    }

    public static ResponseBo error() {
        return ResponseBo.error("");
    }

    public static JSONObject returnData(Object o) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", SUCCESS);
        jsonObject.put("msg", "成功");
        jsonObject.put("data", o);
        return jsonObject;
    }

    public static JSONObject returnData(Object o, long sum) {
        JSONObject jsonObject = returnData(o);
        jsonObject.put("count", sum);
        return jsonObject;
    }

    public static JSONObject returnData(Object o, int sum) {
        JSONObject jsonObject = returnData(o);
        jsonObject.put("count", sum);
        return jsonObject;
    }

    public static JSONObject returnData(Object o, String sum) {
        JSONObject jsonObject = returnData(o);
        jsonObject.put("type", sum);
        return jsonObject;
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
