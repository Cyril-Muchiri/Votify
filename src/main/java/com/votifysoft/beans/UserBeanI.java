package com.votifysoft.beans;

import java.sql.SQLException;

import com.votifysoft.model.entity.User;

public interface UserBeanI {
    boolean register(User user) throws SQLException;

    boolean unregister(User user);
    
}
