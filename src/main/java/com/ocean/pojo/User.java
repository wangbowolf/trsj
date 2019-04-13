package com.ocean.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date 2019/4/7 0007 01:41
 * @Version 1.0
 **/
@Data
public class User implements Serializable {

        private Integer id;
        private String avatar;
        private Integer grade;
        private Date createTime;
        private String typeFavor;
        private String disFavor;
        private String AgeFavor;
        private String firstLetter;
        private String phone;
        private String wxId;
        private String signature;
        private String nickname;
        private String password;
        private String code;

}
