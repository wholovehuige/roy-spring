package com.boot.rabbitmq.dao;

import com.boot.rabbitmq.domain.Login;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by roy on 17-6-13.
 */
public interface LoginDao extends CrudRepository<Login, Long> {

}
