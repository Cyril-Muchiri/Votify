package com.votifysoft.database;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.votifysoft.model.entity.User;

public class UsersDb implements Serializable{
    
    private String databaseCreateAt;

    private List<User> users = new ArrayList<>();


    private static UsersDb dbInstance;

    private UsersDb(){}

    public static UsersDb getDbInstance(){
        if (dbInstance == null) {
            dbInstance = new UsersDb();
            dbInstance.databaseCreateAt = DateFormat.getDateTimeInstance().format(new Date());
            System.out.println("Database created at " + dbInstance.getDatabaseCreateAt());
        }

        return dbInstance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDatabaseCreateAt() {
        return databaseCreateAt;
    }
}


