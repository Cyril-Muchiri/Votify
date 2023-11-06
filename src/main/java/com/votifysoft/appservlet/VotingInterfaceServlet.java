package com.votifysoft.appservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votifysoft.repository.PersonRepository;

@WebServlet("/home")
public class VotingInterfaceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Generate the HTML for the voting interface
        String votingInterfaceHtml = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <meta charset=\"UTF-8\" />\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
            "    <title>Person Cards</title>\n" +
            "    <style>\n" +
            "      .main {\n" +
            "        display: grid;\n" +
            "        gap: 10px;\n" +
            "        max-width: 1200px;\n" +
            "        margin: 0 auto;\n" +
            "      }\n" +
            "      .create-polls {\n" +
            "        border-radius: 10px;\n" +
            "      }\n" +
            "      .active-polls {\n" +
            "        border-radius: 10px;\n" +
            "      }\n" +
            "      .card-container {\n" +
            "        display: flex;\n" +
            "        justify-content: space-around;\n" +
            "        flex-wrap: wrap;\n" +
            "      }\n" +
            "      .card {\n" +
            "        width: 200px;\n" +
            "        border: 1px solid #ccc;\n" +
            "        border-radius: 10px;\n" +
            "        margin: 10px;\n" +
            "        text-align: center;\n" +
            "        padding: 10px;\n" +
            "      }\n" +
            "      .card img {\n" +
            "        border-radius: 50%;\n" +
            "        max-width: 100px;\n" +
            "        max-height: 100px;\n" +
            "        margin-bottom: 10px;\n" +
            "      }\n" +
            "      .card h2 {\n" +
            "        font-size: 1.2em;\n" +
            "        margin-bottom: 5px;\n" +
            "      }\n" +
            "      .vote{\n" +
            "        display: flex;\n" +
            "        justify-content: center;\n" +
            "        height: 15vh;\n" +
            "      }\n" +
            "      .create-polls{\n" +
            "        display: flex;\n" +
            "        height: 15vh;\n" +
            "        justify-content: center;\n" +
            "      }\n" +
            "      .active-polls{\n" +
            "        display: flex;\n" +
            "        height: 15vh;\n" +
            "        justify-content: center;\n" +
            "      }\n" +
            "      .create-btn{\n" +
            "        width: 12vw;\n" +
            "        height: 8vh;\n" +
            "      }\n" +
            "      .vote-btn{\n" +
            "        width: 15vw;\n" +
            "        height: 10vh;\n" +
            "      }\n" +
            "      .view-active{\n" +
            "        width: 25vw;\n" +
            "        height: 10vh;\n" +
            "      }\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <div class=\"main\">\n" +
            "      <div class=\"create-polls\">\n" +
            "        <div>\n" +
            "          <button class=\"create-btn\">create Poll</button>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "      <div class=\"active-polls\">\n" +
            "        <div class=\"div\">\n" +
            "          <button class=\"view-active\">View Active Polls</button>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "      <div class=\"card-container\">\n" +
            "        <div class=\"cont\"></div>\n" +
            "        <div class=\"card\">\n" +
            "          <div class=\"image\">\n" +
            "            <img src=\"person1.jpg\" alt=\"Person 1\" />\n" +
            "          </div>\n" +
            "          <h2>Barack Obama</h2>\n" +
            "          <p>Total Votes: " + PersonRepository.getVotesForPerson(1) + "</p>\n" +
            "          <form action=\"./vote\" method=\"post\">\n" +
            "            <input type=\"hidden\" name=\"personId\" value=\"1\">\n" +
            "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
            "          </form>\n" +
            "        </div>\n" +
            "        <div class=\"card\">\n" +
            "          <img src=\"person2.jpg\" alt=\"Person 2\" />\n" +
            "          <h2>Elon Musk</h2>\n" +
            "          <p>Total Votes: " + PersonRepository.getVotesForPerson(2) + "</p>\n" +
            "          <form action=\"./vote\" method=\"post\">\n" +
            "            <input type=\"hidden\" name=\"personId\" value=\"2\">\n" +
            "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
            "          </form>\n" +
            "        </div>\n" +
            "        <div class=\"card\">\n" +
            "          <img src=\"person3.jpg\" alt=\"Person 3\" />\n" +
            "          <h2>Cyril Muchiri</h2>\n" +
            "          <p>Total Votes: " + PersonRepository.getVotesForPerson(3) + "</p>\n" +
            "          <form action=\"./vote\" method=\"post\">\n" +
            "            <input type=\"hidden\" name=\"personId\" value=\"3\">\n" +
            "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
            "          </form>\n" +
            "        </div>\n" +
            "        <div class=\"card\">\n" +
            "          <img src=\"person4.jpg\" alt=\"Person 4\" />\n" +
            "          <h2>Lopkoiyan</h2>\n" +
            "          <p>Total Votes: " + PersonRepository.getVotesForPerson(4) + "</p>\n" +
            "          <form action=\"./vote\" method=\"post\">\n" +
            "            <input type=\"hidden\" name=\"personId\" value=\"4\">\n" +
            "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
            "          </form>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </body>\n" +
            "</html>";

        // Set the content type and write the HTML to the response
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write(votingInterfaceHtml);
    }
}

