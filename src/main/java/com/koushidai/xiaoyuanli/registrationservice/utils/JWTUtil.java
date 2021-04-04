package com.koushidai.xiaoyuanli.registrationservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    private static String SALT= "salt*&@#*";

    //生成token
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k, v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(SALT)).toString();
    }

    //验证token
    public static void verifyToken(String token){
        JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
    }

    //获取token中的payload
    public static DecodedJWT getPayload(String token){
        return JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
    }
}
