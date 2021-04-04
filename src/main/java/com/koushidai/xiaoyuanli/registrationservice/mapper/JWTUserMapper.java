package com.koushidai.xiaoyuanli.registrationservice.mapper;

import com.koushidai.xiaoyuanli.registrationservice.pojo.JWTUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JWTUserMapper {
    JWTUser login(JWTUser jwtUser);
}
