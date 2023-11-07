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
        // request.getSession();

        if (personIdParam == null || personIdParam.isEmpty()) {
            System.out.println("person id param empty");
        } else {
            int personId = Integer.parseInt(personIdParam);

            // Check if the user has already voted
            if (((Boolean) request.getSession().getAttribute("hasVoted"))) {
                request.setAttribute("message", "You have already voted.");
                request.getRequestDispatcher("/home").forward(request, response);
                System.out.println(request.getSession().getAttribute("hasVoted"));

            } else {
                System.out.println(personId);
                PersonRepository.voteForPerson(personId);
                HomeBean bean = new HomeBean();
                PrintWriter writer = response.getWriter();
                writer.write(bean.userDashboard(true));

            }
        }
    }
}
