package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Long userAccount;
    private String userPassword;
    private String userName;
    private Integer userAge;
    private String userGender;

    public User() {
    }
    public long getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(Long userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return this.userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return this.userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
