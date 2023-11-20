package com.votifysoft.beans;

import java.sql.SQLException;

import com.votifysoft.model.entity.User;

public interface AuthBeanI {

    User authenticate(User loginUser) throws SQLException;
}
