package com.boot.rabbitmq.service.impl;

import com.boot.rabbitmq.dao.LoginDao;
import com.boot.rabbitmq.domain.Login;
import com.boot.rabbitmq.service.LoginService;
import com.boot.rabbitmq.utils.UuidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by roy on 17-6-13.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Autowired
    private EntityManager entityManager;


    public boolean isRegister(String phone) {
        String sql = "SELECT user_id,user_name from login where phone = \'" + phone + "\'";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List<Object[]> list = nativeQuery.getResultList();
        if(list.size()>0) {
            return true;
        }
        return false;
    }

    public Long register(String userName, String phone, String password) {
        if (isRegister(phone)) {
            return null;
        }
        Login login = new Login();
        login.setUserId(UuidService.CreateUuid());
        login.setUserName(userName);
        login.setPhone(phone);
        login.setPassWord(password);
        login.setCrDate(new Date());
        login.setUpDate(new Date());
        loginDao.save(login);
        return login.getId();
    }

    public void findAll() {
//        Sort sort = new Sort();
        Pageable pageable = new PageRequest(0, 10);
        loginDao.findAll(pageable);
    }

}
