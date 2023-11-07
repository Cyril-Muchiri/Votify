package com.votifysoft.pollcreator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.beans.PollCreatorBean;

@WebServlet("/processnames")
public class processNamesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        PollCreatorBean bean = new PollCreatorBean();
        writer.write(bean.createPoll());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> names = new ArrayList<>();

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.equals("names")) {
                String[] values = request.getParameterValues(paramName);
                for (String value : values) {
                    names.add(value);
                }
            }
        }
        for (String name : names) {
            System.out.println("Received Name: " + name);
        }

        

        response.getWriter().write("Names received successfully!");
    }
}
