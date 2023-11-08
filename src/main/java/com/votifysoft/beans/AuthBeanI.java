package com.votifysoft.beans;

import com.votifysoft.model.entity.User;

public interface AuthBeanI {

    User authenticate(User loginUser);
}
