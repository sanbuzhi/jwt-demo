package com.koushidai.xiaoyuanli.registrationservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.testng.annotations.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TestJWT {
    //生成token
    @Test
    public void makeToken(){
        HashMap<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 100000);//20m
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("userId", 1)//payload
                .withClaim("realName", "张三")
                .withExpiresAt(instance.getTime())//指定过期时间
                .sign(Algorithm.HMAC256("this is salt(密钥)"));//签名
        System.out.println("token = " + token);
        //token = eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZWFsTmFtZSI6IuW8oOS4iSIsImV4cCI6MTYxNzU2ODI2NCwidXNlcklkIjoxfQ.som6Zfy3I8MKoL5XbxIgyNH2eC6zugH5SNrLwC4oMXc
    }

    //验证token
    @Test
    public void verifyToken(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("this is salt(密钥)")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZWFsTmFtZSI6IuW8oOS4iSIsImV4cCI6MTYxNzU2ODQ2OSwidXNlcklkIjoxfQ.qXAuPiFOq2OQZRUZorn5O0JvLhwIbEg00PQ5Qj333S0");
        String header = decodedJWT.getHeader();
        System.out.println("header = " + header);
        String payload = decodedJWT.getPayload();
        System.out.println("payload = " + payload);
        String signature = decodedJWT.getSignature();
        System.out.println("signature = " + signature);
        String token = decodedJWT.getToken();
        System.out.println("token = " + token);
        System.out.println("\n");
        int userId = decodedJWT.getClaim("userId").asInt();
        System.out.println("userId = " + userId);
        String realName = decodedJWT.getClaim("realName").asString();
        System.out.println("realName = " + realName);
        System.out.println("\n");
        int userId1 = decodedJWT.getClaims().get("userId").asInt();
        System.out.println("userId1 = " + userId1);
        String realName1 = decodedJWT.getClaims().get("realName").asString();
        System.out.println("realName1 = " + realName1);

        Date expiresAt = decodedJWT.getExpiresAt();
        System.out.println("expiresAt = " + expiresAt);

    }
}