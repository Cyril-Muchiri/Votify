package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.votifysoft.beans.HomeBean;


@WebServlet("/home")
public class VotingInterfaceServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        session.setAttribute("hasVoted",false);
        HomeBean homeBean=new HomeBean();

        PrintWriter writer=resp.getWriter();

       writer.write(homeBean.userDashboard((boolean) (session.getAttribute("hasVoted"))));

    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession();
                session.setAttribute("hasVoted", true);

    RequestDispatcher dispatcher = request.getRequestDispatcher("./vote");
    dispatcher.forward(request, response);
    }
}
