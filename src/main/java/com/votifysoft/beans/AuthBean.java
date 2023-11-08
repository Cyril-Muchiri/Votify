package com.votifysoft.beans;

import java.io.Serializable;

import com.votifysoft.database.UsersDb;
import com.votifysoft.model.entity.User;

public class AuthBean implements AuthBeanI, Serializable {

    UsersDb database = UsersDb.getDbInstance();

    public User authenticate(User loginUser) {

        User userDetails = null;

        for (User user : database.getUsers()) {
            if(loginUser.getUsername().equals(user.getUserEmail())
            && loginUser.getPassword().equals(user.getPassword())) {
                userDetails = user;

                break;

            }else{
                System.out.println("Unkown error!!");
            }
        }

        return userDetails;
    }
}
