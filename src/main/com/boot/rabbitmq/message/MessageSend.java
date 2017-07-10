//package com.boot.rabbitmq.message;
//
//import com.boot.rabbitmq.config.RabbitMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * Created by roy on 17-5-23.
// */
//@Component
//public class MessageSend {
//    @Autowired
//    private RabbitMQTemplate rabbitMQTemplate;
//
//    public void send(String queue,String content) {
//        rabbitMQTemplate.send(queue,content);
//    }
//
//}
