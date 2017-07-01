package com.boot.rabbitmq.utils;

import java.util.UUID;

/**
 * Created by roy on 17-6-30.
 */
public class UuidService {
    public static String CreateUuid() {
        String token = UUID.randomUUID().toString();
        String result = token.replaceAll("-", "");
        return result;
    }

}
