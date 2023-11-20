package com.votifysoft.model.entity;

import java.io.Serializable;

import com.votifysoft.database.helper.DbTable;
import com.votifysoft.database.helper.DbTableColumn;


@DbTable(name = "users")
public class User implements Serializable {

    @DbTableColumn(name = "id", definition = "int")
    private Long id;

    @DbTableColumn(name = "username")
    private String username;

    @DbTableColumn(name = "userEmail")
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @DbTableColumn(name = "password")
    private String password;

    public User(){}

    public User(Long id, String username,String userEmail, String password) {
        this.id = id;
        this.username = username;
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}