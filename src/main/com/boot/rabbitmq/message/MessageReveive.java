//package com.boot.rabbitmq.message;
//
//import com.boot.rabbitmq.config.RabbitMQTemplate;
//import com.boot.rabbitmq.domain.External;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
///**
// * Created by roy on 17-5-24.
// */
//@Component
//public class MessageReveive {
//    @Autowired
//    private RabbitMQTemplate rabbitMQTemplate;
//
//    @RabbitListener(queues = External.test)
//    public void messageReveive1(Message message) {
//        String content = "";
//        try {
//            content =new String(message.getBody(),"UTF-8");
//            System.out.println("==========111" + content);
//        } catch (Exception e) {
//            rabbitMQTemplate.send(External.testDead,content);
//        }
//
//    }
//
//
//    @RabbitListener(queues = External.test)
//    public void messageReveive2(Message message) {
//        String content = "";
//        try {
//            content =new String(message.getBody(),"UTF-8");
//            System.out.println("==========222" + content);
//        } catch (Exception e) {
//            rabbitMQTemplate.send(External.testDead,content);
//        }
//
//    }
//
//    @RabbitListener(queues = External.test)
//    public void messageReveive3(Message message) {
//        String content = "";
//        try {
//            content =new String(message.getBody(),"UTF-8");
//            System.out.println("==========333" + content);
//        } catch (Exception e) {
//            rabbitMQTemplate.send(External.testDead,content);
//        }
//
//    }
//
//    @RabbitListener(queues = External.test)
//    public void messageReveive4(Message message) {
//        String content = "";
//        try {
//            content =new String(message.getBody(),"UTF-8");
//            System.out.println("==========444" + content);
//        } catch (Exception e) {
//            rabbitMQTemplate.send(External.testDead,content);
//        }
//
//    }
//
//}
