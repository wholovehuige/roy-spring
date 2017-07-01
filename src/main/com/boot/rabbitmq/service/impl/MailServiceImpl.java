package com.boot.rabbitmq.service.impl;

import com.boot.rabbitmq.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by roy on 17-6-21.
 */
@Component
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender mailSender;

    private static String from = "673713797@qq.com";

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            System.out.println("简单邮件已经发送");
        } catch (Exception e) {
            System.out.println("发送简单邮件时发生异常！"+ e);
        }

    }
}
