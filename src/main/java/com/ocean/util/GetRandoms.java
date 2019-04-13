package com.ocean.util;

import java.util.Random;

/**
 * @ClassName GetRandoms
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/7 0007 00:47
 * @Version 1.0
 **/
public class GetRandoms {

    public static String getRandoms(){
        Random random = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < 6; j++){
            flag.append(random.nextInt(10) + "");
        }
        return flag.toString();
    }
}
