package com.koushidai.xiaoyuanli.registrationservice.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JWTUser {
    private String userId;
    private String userName;
    private String passWord;
}
