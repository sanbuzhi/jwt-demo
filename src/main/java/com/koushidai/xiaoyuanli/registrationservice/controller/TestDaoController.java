package com.koushidai.xiaoyuanli.registrationservice.controller;

import com.koushidai.xiaoyuanli.registrationservice.mapper.UserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDaoController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/userdao/test1")
    public String test1(){
        UserInfoDomain userInfoById = userMapper.getUserInfoById(1);
        System.out.println("userInfoById = " + userInfoById);

        UserInfoDomain userInfoDomain = new UserInfoDomain(2, "xxx", "xxx", 123, "ssdf", "fsdf", 122131);
        Integer i = userMapper.ifUserExist(userInfoDomain);
        System.out.println("ixxx = " + i);

        Integer integer = userMapper.insertUser(userInfoDomain);
        System.out.println("integer = " + integer);

        return "111";
    }
}
