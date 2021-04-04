package com.koushidai.xiaoyuanli.registrationservice.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.koushidai.xiaoyuanli.registrationservice.utils.JWTUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JWTInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String, Object> map = new HashMap<>();
        try {
            JWTUtil.verifyToken(token);
            //令牌验证成功后的业务逻辑...
            return true;//放行请求
        }catch (SignatureVerificationException sve){
            sve.printStackTrace();
            map.put("msg", "无效签名!");
        }catch (TokenExpiredException tee){
            tee.printStackTrace();
            map.put("msg", "token过期!");
        }catch (AlgorithmMismatchException ame){
            ame.printStackTrace();
            map.put("msg", "算法不一致!");
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("msg", "其他异常!");
        }
        map.put("state", false);
        //将map转为json   jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
