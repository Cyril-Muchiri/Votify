package com.votifysoft.auth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.votifysoft.database.UserRegistry;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream inputStream = getServletContext().getResourceAsStream("./index.html");
        response.setContentType("text/html");
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userEmail = req.getParameter("email");
        String userPass = req.getParameter("password");

        if ((UserRegistry.authenticate(userEmail, userPass))) {
            HttpSession session = req.getSession();
            session.setAttribute("userEmail", userEmail);
            // session.setAttribute("hasVoted", false);
            System.out.println("login user" + userEmail + " " + userPass);
            req.getRequestDispatcher("/home").forward(req, res);

        } else {
            PrintWriter writer = res.getWriter();
            System.out.println("failed user" + userEmail + " " + userPass);
            writer.println("<h1>invalid login <a href=\".\">Login again</a></h1>");
        }
    }

}
