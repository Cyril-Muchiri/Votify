package com.votifysoft.beans;

import com.votifysoft.model.entity.User;

public interface UserBeanI {
    boolean register(User user);

    boolean unregister(User user);
    
}
