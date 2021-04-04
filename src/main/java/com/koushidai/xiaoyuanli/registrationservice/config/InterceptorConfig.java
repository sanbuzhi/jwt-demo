package com.koushidai.xiaoyuanli.registrationservice.config;

import com.koushidai.xiaoyuanli.registrationservice.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")//拦截所有路径
                .excludePathPatterns("/user/login");//放行用户登录，其他接口进行jwt token验证
    }
}
