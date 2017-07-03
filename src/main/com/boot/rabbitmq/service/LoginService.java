package com.boot.rabbitmq.service;

/**
 * Created by roy on 2017/7/2.
 */
public interface LoginService {

    Long register(String userName,String phone,String password);

}
