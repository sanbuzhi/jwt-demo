package com.koushidai.xiaoyuanli.registrationservice.service;

import com.auth0.jwt.JWT;
import com.koushidai.xiaoyuanli.registrationservice.mapper.JWTUserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.JWTUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JWTUserServiceImpl implements JWTUserService {

    @Autowired
    private JWTUserMapper jwtUserMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public JWTUser login(JWTUser jwtUser) {
        JWTUser userDB = jwtUserMapper.login(jwtUser);
        if(userDB != null)
            return userDB;
        throw new RuntimeException("登录失败- -");
    }
}
