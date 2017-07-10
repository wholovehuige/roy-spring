//package com.boot.rabbitmq.config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by roy on 17-5-23.
// */
//@Component
//public class RabbitMQTemplate {
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send(String queueName,String message) {
//        rabbitTemplate.convertAndSend(queueName,message);
//    }
//
//}
