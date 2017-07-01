package com.boot.rabbitmq.web.request;

/**
 * Created by roy on 17-6-30.
 */
public class LonginRequest {
    private String phone;
    private String password;
    private String userName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
