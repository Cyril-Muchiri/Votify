package com.votifysoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/chief")
public class App implements Servlet {

    @Override
    public void destroy() {
        System.out.println("This servlet is shutting down");
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServletConfig'");
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServletInfo'");
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("This servlet has been initialized!!");
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        PrintWriter writer = arg1.getWriter();

        int numberStr1 = Integer.parseInt(arg0.getParameter("number1"));
        int numberStr2 = Integer.parseInt(arg0.getParameter("number2"));

        int sum = numberStr1 + numberStr2;

        writer.print("<h1>THIS IS A TEST PAGE GENERATED!!</h1>"
                + "<br>" +
                "<h2>The result of adding " + numberStr1 + " + " + numberStr2
                + " is "
                + sum);
    }

}
