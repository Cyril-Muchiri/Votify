package com.votifysoft.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.beans.UserBean;
import com.votifysoft.beans.UserBeanI;
import com.votifysoft.model.entity.User;

import java.io.IOException;

 @WebServlet("/register")
public class UserAction extends BaseAction {

    UserBeanI userBean = new UserBean();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User registerUser = new User();
        serializeForm(registerUser, req.getParameterMap());

        userBean.register(registerUser);

        resp.sendRedirect("./");

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.sendRedirect("./register.html");
    }
}
