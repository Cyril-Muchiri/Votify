package com.votifysoft.beans;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import com.votifysoft.database.MySqlDb;
import com.votifysoft.database.UsersDb;
import com.votifysoft.model.entity.User;

public class UserBean implements UserBeanI,Serializable {
UsersDb database = UsersDb.getDbInstance();

    @Override
    public  boolean register(User user) throws SQLException {

        if (user.getPassword() !=null) {
           
            PreparedStatement sqlStmt = MySqlDb.getInstance().getConnection()
                .prepareStatement("insert into users(id,username,userEmail,password) values(?,?,?,?)");

            sqlStmt.setInt(1, ThreadLocalRandom.current().nextInt(1, 1000));
            sqlStmt.setString(2, user.getUsername());
            sqlStmt.setString(3, user.getUserEmail());
            sqlStmt.setString(4, user.getPassword());

            sqlStmt.executeUpdate();

            return true;
        }

        return false;
    }

    @Override
    public boolean unregister(User user) {
        return true;
    }
}

