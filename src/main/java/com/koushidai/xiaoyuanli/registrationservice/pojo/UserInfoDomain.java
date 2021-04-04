package com.koushidai.xiaoyuanli.registrationservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDomain implements Serializable {
    private Integer userId;//用户Id
    private String nickName;//昵称
    private String realName;//真实姓名
    private Integer schoolId;//学校Id
    private String contactAddress;//联系地址
    private String contactEmail;//联系邮箱
    private Integer contactPhoneNum;//联系电话
}
