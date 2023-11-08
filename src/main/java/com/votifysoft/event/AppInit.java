package com.votifysoft.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.votifysoft.database.UsersDb;
import com.votifysoft.model.entity.User;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*************** Initializing database *************");

        UsersDb database = UsersDb.getDbInstance();
        database.getUsers().add(new User(0L, "Cyril Muchiri", "123","abc@test.com"));
         database.getUsers().add(new User(0L, "Muchiri Muchiri", "123","abc.abc@test.com"));
          database.getUsers().add(new User(0L, "Mwangi Muchiri", "123","abc@gmail.com"));
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application is undeployed or destroyed");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

}
