package com.votifysoft.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        String userPass = req.getParameter("pass");

        if (userEmail.equals("chief@test.com") && userPass.equals("Admin123")) {
            PrintWriter writer = res.getWriter();
            writer.println("<h1>Welclome " + userEmail + "</h1>");
        } else {
            PrintWriter writer = res.getWriter();
            writer.println("<h1>invalid login <a href=\".\">Login again</a></h1>");
        }
    }

}