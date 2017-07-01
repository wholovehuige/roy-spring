package com.boot.rabbitmq.service.impl;

import com.boot.rabbitmq.dao.LoginDao;
import com.boot.rabbitmq.domain.Login;
import com.boot.rabbitmq.utils.UuidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by roy on 17-6-13.
 */
@Service
public class LoginServiceImpl {
    @Resource
    private LoginDao loginDao;

    public void test(String userName,String phone,String password) {
        Login login = new Login();
        login.setUserId(UuidService.CreateUuid());
        login.setUserName(userName);
        login.setPhone(phone);
        login.setPassWord(password);
        login.setCrDate(new Date());
        login.setUpDate(new Date());
        loginDao.save(login);
        System.out.println("id="+login.getId());
    }

}
