package com.koushidai.xiaoyuanli.registrationservice.service;

import com.koushidai.xiaoyuanli.registrationservice.pojo.JWTUser;

public interface JWTUserService {
    JWTUser login(JWTUser jwtUser);
}
