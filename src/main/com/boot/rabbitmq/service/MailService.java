package com.boot.rabbitmq.service;

import org.springframework.stereotype.Component;

/**
 * Created by roy on 17-6-21.
 */
@Component
public interface MailService {
     void sendSimpleMail(String to, String subject, String content);
}
