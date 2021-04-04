package com.koushidai.xiaoyuanli.registrationservice.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.koushidai.xiaoyuanli.registrationservice.pojo.JWTUser;
import com.koushidai.xiaoyuanli.registrationservice.service.JWTUserService;
import com.koushidai.xiaoyuanli.registrationservice.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class JWTUserController {
    @Autowired
    private JWTUserService userService;

    //使用session的方式
    /*@GetMapping("/user/login")
    public Map<String,Object> login(JWTUser jwtUser){
        log.info("userName = " + jwtUser.getUserName());
        log.info("passWord = " + jwtUser.getPassWord());
        HashMap<String, Object> map = new HashMap<>();

        try {
            JWTUser userDB = userService.login(jwtUser);
            map.put("state", true);
            map.put("msg", "认证成功!");
        }catch (Exception ex){
            map.put("state", false);
            map.put("msg", "认证失败!");
        }
        return map;
    }*/

    //token的方式
    @GetMapping("/user/login")
    public Map<String,Object> login(JWTUser jwtUser){
        log.info("userName = " + jwtUser.getUserName());
        log.info("passWord = " + jwtUser.getPassWord());
        HashMap<String, Object> map = new HashMap<>();

        try {
            JWTUser userDB = userService.login(jwtUser);
            HashMap<String, String> payload = new HashMap<>();
            payload.put("userId", jwtUser.getUserId());
            payload.put("userName", jwtUser.getUserName());
            String token = JWTUtil.getToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功!");
            map.put("token", token);
        }catch (Exception ex){
            map.put("state", false);
            map.put("msg", "认证失败!");
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        //处理自己的业务逻辑
        //需要从token里取出携带的信息，就从HttpServletRequest获取header信息，再获取token
        //前端的token存在哪呢？localStore，localSession，由前端人员自己决定
        String token = request.getHeader("token");
        //JWTUtil....
        map.put("state", true);
        map.put("msg", "认证成功!");
        return map;
    }
}
