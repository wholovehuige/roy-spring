package com.boot.rabbitmq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by roy on 17-6-13.
 */
@Repository
@Configuration
public class Redis {
    @Autowired
    private RedisTemplate redisTemplate;

    //添加
    public void add(String key,String value) {
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set(key,value,3, TimeUnit.MINUTES);
    }

    public String search(String key) {
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

}
