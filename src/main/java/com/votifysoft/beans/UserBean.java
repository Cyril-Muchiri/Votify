package com.votifysoft.beans;

import java.io.Serializable;

import com.votifysoft.database.UsersDb;
import com.votifysoft.model.entity.User;

public class UserBean implements UserBeanI,Serializable {
UsersDb database = UsersDb.getDbInstance();

    @Override
    public boolean register(User user) {

        if (user.getPassword().equals(user.getConfirmPassword())) {
            database.getUsers().add(new User(100L, user.getUsername(), user.getPassword(),user.getUserEmail()));
           

            return true;
        }

        return false;
    }

    @Override
    public boolean unregister(User user) {
        return true;
    }
}

