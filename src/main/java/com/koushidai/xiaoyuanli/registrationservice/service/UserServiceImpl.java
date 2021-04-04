package com.koushidai.xiaoyuanli.registrationservice.service;

import com.koushidai.xiaoyuanli.registrationservice.mapper.UserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int registraUser(UserInfoDomain user) {
        int effectCount = userMapper.ifUserExist(user);
        if(effectCount==0){
            int i = userMapper.insertUser(user);
            if(i==1)
                return 1;
        }
        return 0;
    }
}
