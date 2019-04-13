package com.ocean.controller;

import com.ocean.pojo.ResponseBo;
import com.ocean.pojo.User;
import com.ocean.service.UserService;
import com.ocean.util.GetRandoms;
import com.ocean.util.SimpleSMSSender;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @className UserLogin
 * @description TODO:登陆验证
 * @author Administrator
 * @date 2019/4/3
 * @version 1.0
 **/
@RestController
public class UserLoginController {

    private final static String TEMP_CODE = "SMS_162197307";

    private final static String OK = "ok";

    @Resource
    private SimpleSMSSender simpleSMSSender;

    @Resource
    private UserService userService;

    //发送验证码
    @GetMapping("/sms")
    public ResponseBo smsAuto(@RequestParam String phone, HttpServletRequest httpServletRequest){
        SimpleSMSSender.SMS sms = SimpleSMSSender.newSMS();
        sms.setPhoneNumbers(phone);
        String randoms = GetRandoms.getRandoms();
        sms.setTemplateParam("{\"code\":\""+randoms+"\"}");
        sms.setTemplateCode(TEMP_CODE);
        SimpleSMSSender.Result result = simpleSMSSender.sendSms(sms);
        if(OK.equalsIgnoreCase(result.getSendSmsResponse().getMessage())){
            httpServletRequest.getSession().setAttribute(phone, randoms);
            return ResponseBo.ok();
        }
        return ResponseBo.error();
    }

    //登陆or注册
    @PostMapping("/login")
    public ResponseBo login(@RequestBody User user, HttpSession httpSession){
        String attribute = (String) httpSession.getAttribute(user.getPhone());
        if(null != attribute && attribute.equalsIgnoreCase(user.getCode())){
            if(null == userService.getUser(user.getPhone())){
                userService.addUserInPhone(user.getPhone());
            }
            return ResponseBo.ok("登陆成功!");
        }
        return ResponseBo.error("验证码不正确,请重新登陆");
    }
}