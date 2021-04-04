package com.koushidai.xiaoyuanli.registrationservice;

import com.koushidai.xiaoyuanli.registrationservice.mapper.UserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    private UserMapper userMapper;

    @org.testng.annotations.Test
    public void test(){
        UserInfoDomain userInfoById = userMapper.getUserInfoById(1);
        System.out.println(userInfoById.toString());
    }
}
