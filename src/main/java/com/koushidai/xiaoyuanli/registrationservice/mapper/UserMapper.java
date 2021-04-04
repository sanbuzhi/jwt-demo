package com.koushidai.xiaoyuanli.registrationservice.mapper;

import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 插入一条用户信息
     */
    int insertUser(UserInfoDomain user);

    /**
     * 通过用户id获取用户信息
     */
    UserInfoDomain getUserInfoById(Integer userId);

    /**
     * 判断用户是否已经存在
     */
    int ifUserExist(UserInfoDomain user);
}