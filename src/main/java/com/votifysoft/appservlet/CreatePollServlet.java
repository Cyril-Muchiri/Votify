package com.votifysoft.appservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newPoll")
public class CreatePollServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./createPoll.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String decodedNames = decodeUrl(sb);

        List<String> names = Arrays.asList(decodedNames.split(","));

        response.getWriter().write("<script>createCardContainer(" + names + ");</script>");

        String cardContainerHTML = generateCardContainerHTML(names);
        request.setAttribute("cardContainerHTML", cardContainerHTML);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);

    }

    private static String decodeUrl(StringBuilder sb) {
        try {
            return URLDecoder.decode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateCardContainerHTML(List<String> names) {
        StringBuilder html = new StringBuilder("<div class=\"card-container\">");
    
        for (int index = 0; index <names.size(); index++) {
            html.append("<div class=\"card\">");
            html.append("<c:set var=\"personName\" value=\"").append(names.get(index)).append("\" />");
            html.append("<h2>").append("${personName}").append("</h2>");
            html.append("<p>Total Votes: 0</p>");
            html.append("<c:choose>");
            html.append("<c:when test=\"${sessionScope.hasVoted}\">");
            // html.append("<form action=\"./vote\" method=\"post\">");
            // html.append("<input type=\"hidden\" name=\"personId\" value=\"").append(index).append("\">");
            // html.append("<button type=\"submit\" class=\"vote-btn\" disabled>Already Voted</button>");
            // html.append("</form>");
            html.append("</c:when>");
            html.append("<c:otherwise>");
            html.append("<form action=\"./vote\" method=\"post\">");
            html.append("<input type=\"hidden\" name=\"personId\" value=\"").append(index).append("\">");
            html.append("<button type=\"submit\" class=\"vote-btn\">Vote</button>");
            html.append("</form>");
            html.append("</c:otherwise>");
            html.append("</c:choose>");
            html.append("</div>");
        }
    
        html.append("</div>");
        return html.toString();
    }

}
