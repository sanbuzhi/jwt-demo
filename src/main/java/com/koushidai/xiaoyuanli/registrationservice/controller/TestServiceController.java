package com.koushidai.xiaoyuanli.registrationservice.controller;

import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import com.koushidai.xiaoyuanli.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

@RestController("/service")
public class TestServiceController {
    @Autowired
    private UserService userService;


    @RequestMapping("/userservice/test1")
    public void test1(){
        UserInfoDomain userInfoDomain = new UserInfoDomain(2, "xxx", "xxx", 123, "ssdf", "fsdf", 122131);
        Integer integer = userService.registraUser(userInfoDomain);
        System.out.println(integer);
    }

    @Test
    public void test(){
    }
}
