package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.beans.HomeBean;

@WebServlet("/home")
public class VotingInterfaceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HomeBean homeBean = new HomeBean();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write(homeBean.userDashboard());
    }
}
