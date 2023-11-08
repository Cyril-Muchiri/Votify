package com.votifysoft.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.votifysoft.beans.AuthBean;
import com.votifysoft.beans.AuthBeanI;
import com.votifysoft.database.UsersDb;
import com.votifysoft.model.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {

    AuthBeanI authBean = new AuthBean();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId")))
            resp.sendRedirect("./home");
        else {
            resp.sendRedirect("./");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        String userPass = req.getParameter("password");

        UsersDb db = UsersDb.getDbInstance();
        System.out.println("db created at: " + db.getDatabaseCreateAt());
        for (User user : db.getUsers()) {
            if (userEmail.equals(user.getUserEmail()) && userPass.equals(user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("loggedInId", new Date().getTime() + "");
                session.setAttribute("userEmail", userEmail);
                session.setAttribute("hasVoted",false);

                resp.sendRedirect("./home");
            }
        }

        PrintWriter print = resp.getWriter();
        print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");

    }

}
