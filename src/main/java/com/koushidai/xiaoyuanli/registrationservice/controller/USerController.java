package com.koushidai.xiaoyuanli.registrationservice.controller;

import com.koushidai.xiaoyuanli.registrationservice.mapper.UserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import com.koushidai.xiaoyuanli.registrationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class USerController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
