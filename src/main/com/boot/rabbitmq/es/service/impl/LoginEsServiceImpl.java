package com.boot.rabbitmq.es.service.impl;

import com.boot.rabbitmq.es.domain.LoginEs;
import com.boot.rabbitmq.es.repository.LoginEsRepository;
import com.boot.rabbitmq.es.service.LoginEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by roy on 17-7-12.
 */
@Service
public class LoginEsServiceImpl implements LoginEsService{
    @Autowired
    private LoginEsRepository loginEsRepository;

    @Override
    public Long saveLoginEs(LoginEs loginEs) {
        loginEsRepository.save(loginEs);
        return loginEs.getId();
    }
}
