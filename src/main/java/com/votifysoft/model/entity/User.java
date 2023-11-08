package com.votifysoft.model.entity;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;

    private String userName;

    private String userEmail;

    private String password;

    private String confirmPassword;

    public User(){}

    public User(Long id, String userName, String password,String userEmail) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userEmail=userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

      public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}