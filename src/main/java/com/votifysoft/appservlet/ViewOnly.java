package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.beans.HomeBean;

@WebServlet("voted")
public class ViewOnly extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HomeBean bean = new HomeBean();
        PrintWriter writer = response.getWriter();
        writer.write(bean.userDashboard(true));

    }
}
