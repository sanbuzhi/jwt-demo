package com.koushidai.xiaoyuanli.registrationservice;

import com.koushidai.xiaoyuanli.registrationservice.mapper.UserMapper;
import com.koushidai.xiaoyuanli.registrationservice.pojo.UserInfoDomain;
import com.koushidai.xiaoyuanli.registrationservice.service.UserService;
import com.koushidai.xiaoyuanli.registrationservice.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RegistrationServiceApplicationTests {


    @Test
    void contextLoads() {
    }

    @org.junit.Test
    public void testservice(){
        SpringUtils utils = new SpringUtils();
        UserService userServiceImpl = (UserService) utils.getBean(UserServiceImpl.class);
        int i = userServiceImpl.registraUser(new UserInfoDomain(2, "xxx", "xxx", 123, "ssdf", "fsdf", 122131));
        System.out.println("iii = " + i);
    }

}
