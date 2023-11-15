package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.votifysoft.beans.HomeBean;
import com.votifysoft.repository.PersonRepository;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        session.setAttribute("hasVoted",true);
        resp.sendRedirect("./home.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String personIdParam = request.getParameter("personId");
        

        if (personIdParam == null || personIdParam.isEmpty()) {
            System.out.println("person id param empty");
        } else {
            int personId = Integer.parseInt(personIdParam);
            System.out.println(request.getSession().getAttribute("hasVoted"));

            // Check if the user has already voted
            if (((Boolean) request.getSession().getAttribute("hasVoted"))) {
                request.setAttribute("message", "You have already voted.");
                request.getRequestDispatcher("/home").forward(request, response);
                System.out.println(request.getSession().getAttribute("hasVoted"));
                 HomeBean bean = new HomeBean();
                PrintWriter writer = response.getWriter();
                writer.write(bean.userDashboard(true));

            } else {
               
                PersonRepository.voteForPerson(personId);
                request.getSession().setAttribute("voteSuccessMessage", "Your vote has been cast successfully!");

                // Set hasVoted attribute to true in the session
                request.getSession().setAttribute("hasVoted", true);
    
                // Forward the request to home.jsp
                request.getRequestDispatcher("/home.jsp").forward(request, response);

            }
        }
    }
}
