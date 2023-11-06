package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.beans.HomeBean;
import com.votifysoft.repository.PersonRepository;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String personIdParam = request.getParameter("personId");
        if (personIdParam == null || personIdParam.isEmpty()) {
            System.out.println("person id param empty");
        } else {
            int personId = Integer.parseInt(request.getParameter("personId"));
            System.out.println(personId);
            PersonRepository.voteForPerson(personId);

            HomeBean homeBean=new HomeBean();
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.write(homeBean.userDashboard());
        }
    }
}
