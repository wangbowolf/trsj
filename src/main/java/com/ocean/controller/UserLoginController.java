package com.ocean.controller;

import com.ocean.annotation.PassToken;
import com.ocean.pojo.ResponseBo;
import com.ocean.pojo.User;
import com.ocean.service.UserService;
import com.ocean.util.GetRandoms;
import com.ocean.util.GetToken;
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
    @PassToken
    public ResponseBo smsAuto(@RequestParam String phone, HttpServletRequest httpServletRequest){
        //测试先不去请求阿里云, 直接用123456代替
        /*SimpleSMSSender.SMS sms = SimpleSMSSender.newSMS();
        sms.setPhoneNumbers(phone);
        String randoms = GetRandoms.getRandoms();
        sms.setTemplateParam("{\"code\":\""+randoms+"\"}");
        sms.setTemplateCode(TEMP_CODE);
        SimpleSMSSender.Result result = simpleSMSSender.sendSms(sms);
        if(OK.equalsIgnoreCase(result.getSendSmsResponse().getMessage())){
            httpServletRequest.getSession().setAttribute(phone, randoms);
            return ResponseBo.ok();
        }
        return ResponseBo.error();*/
        httpServletRequest.getSession().setAttribute(phone, "123456");
        return ResponseBo.ok();
    }

    //登陆or注册
    @PostMapping("/login")
    @PassToken
    public ResponseBo login(@RequestBody User user, HttpSession httpSession){
        String attribute = (String) httpSession.getAttribute(user.getPhone());
        if(null != attribute && attribute.equalsIgnoreCase(user.getCode())){
            if(null == userService.getUser(user.getPhone())){
                userService.addUserInPhone(user.getPhone());
            }
            String token = GetToken.getToken(user);
            return ResponseBo.success()
                      .put("token", token)
                      .put("user", user);
        }
        return ResponseBo.error("验证码不正确,请重新登陆");
    }
}
