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
public boolean register(User user) throws SQLException {

    if (user.getPassword() != null) {

        MySqlDb.insert(user);

        return true;
    }

    return false;
}
    public boolean unregister(User user) {
        return true;
    }
}

