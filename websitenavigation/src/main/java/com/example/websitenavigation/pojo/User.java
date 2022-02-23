package com.example.websitenavigation.pojo;

import com.example.websitenavigation.utils.TextDealing;

import java.io.Serializable;

/**
 * t_user
 * @author 
 */
public class User implements Serializable {
    private Integer id;

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userMotto;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
    }
}