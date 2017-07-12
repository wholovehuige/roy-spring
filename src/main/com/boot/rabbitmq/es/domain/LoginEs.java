package com.boot.rabbitmq.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by roy on 17-7-12.
 */
@Document(indexName = "blog", type = "user")
public class LoginEs {

    private Long id;
    private String userId;
    private String userName;
    private String phone;
    private String passWord;
    private Date crDate;
    private Date upDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
