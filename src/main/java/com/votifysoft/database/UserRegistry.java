package com.votifysoft.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserRegistry extends HttpServlet {
    private static List<User> users = new ArrayList<>();
    // private static Map<String, User> userNameToUser = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userNmail");
        String password = request.getParameter("password");
        String email = request.getParameter("userEmail");

        boolean registrationSuccess = registerUser(userName, password, email);

        if (registrationSuccess) {
            PrintWriter writer = response.getWriter();
            // writer.write("Registration successful! ");
            System.out.println("Registration successful! "+email + " & " + password);
            response.sendRedirect("./login");
        } else {
            PrintWriter writer = response.getWriter();
            writer.write("Username already exists. Please choose a different username.");
            response.sendRedirect("./register");
        }
    }

    public static boolean registerUser(String username, String password, String email) {
        // User user = new User(username, password, email);
        // users.add(user);
        // userNameToUser.put(username, user);
        UsersDb userAdd=UsersDb.getDbInstance();
        userAdd.getUsers().add(new com.votifysoft.model.entity.User(null, username, password, email));
        return true;
    }

    // public static boolean authenticate(String userEmail, String password) {
    //     User user = userNameToUser.get(userEmail);
    //     if (user != null && user.getPassword().equals(password)) {
    //         System.out.println("auth user " + userEmail + " " + password);
    //         return true;
    //     } else {
    //         // System.out.println(user.getEmail()+" "+user.getPassword());
    //         return true;
    //     }

    // }

    static class User {
        private String username;
        private String password;
        private String email;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }
    }
}