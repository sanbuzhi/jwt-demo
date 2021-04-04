package com.koushidai.xiaoyuanli.registrationservice.service;

import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;

public interface UserService {
    //注册一个用户
    public int registraUser(UserInfoDomain user);
}
