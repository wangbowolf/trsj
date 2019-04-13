package com.ocean.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ocean.pojo.User;

/**
 * @ClassName GetToken
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/13 0013 16:48
 * @Version 1.0
 **/
public class GetToken {

    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getPhone())
                .sign(Algorithm.HMAC256(user.getPhone()));
        return token;
    }
}
