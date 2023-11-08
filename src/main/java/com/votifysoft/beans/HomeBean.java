package com.votifysoft.beans;

import com.votifysoft.css.HomeCss;
import com.votifysoft.repository.PersonRepository;

public class HomeBean {
    public String userDashboard(Boolean hasVoted) {

        String popupScript = hasVoted ? "alert('You have voted succesfully !');" : "";
        if (hasVoted) {
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "  <head>\n" +
                    "    <meta charset=\"UTF-8\" />\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                    "    <title>Person Cards</title>\n" +
                    "<style>\n" +
                    "      body {\n" +
                    "        background-color: antiquewhite;\n" +
                    "          font-family: Arial, sans-serif;\n" +
                    "          display: flex;\n" +
                    "          margin-top: 5%;\n" +
                    "      }\n" +
                    "\n" +
                    "      .main {\n" +
                    "          display: grid;\n" +
                    "          gap: 20px;\n" +
                    "          max-width: 1200px;\n" +
                    "          margin: 0 auto;\n" +
                    "          background-color: #fff;\n" +
                    "          padding: 20px;\n" +
                    "          border-radius: 10px;\n" +
                    "          box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
                    "      }\n" +
                    "\n" +
                    "      .card-container {\n" +
                    "          display: flex;\n" +
                    "          justify-content: space-evenly;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout-btn {\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout-btn:hover {\n" +
                    "          background-color: #4b6f9f;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls,\n" +
                    "      .div {\n" +
                    "          color: #fff;\n" +
                    "          border-radius: 5px;\n" +
                    "          padding: 10px 20px;\n" +
                    "          text-align: center;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls .view-active,\n" +
                    "      .div button {\n" +
                    "          color: black;\n" +
                    "          \n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "          margin-top: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls .view-active:hover,\n" +
                    "      .div button:hover {\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card {\n" +
                    "          width: 200px;\n" +
                    "          border: 1px solid #ccc;\n" +
                    "          border-radius: 10px;\n" +
                    "          margin: 10px;\n" +
                    "          text-align: center;\n" +
                    "          padding: 10px;\n" +
                    "          background-color: #fff;\n" +
                    "          box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                    "          display: inline-block;\n" +
                    "\n" +
                    "      }\n" +
                    "\n" +
                    "      .card img {\n" +
                    "          border-radius: 50%;\n" +
                    "          max-width: 100px;\n" +
                    "          max-height: 100px;\n" +
                    "          margin-bottom: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card h2 {\n" +
                    "          font-size: 1.2em;\n" +
                    "          margin-bottom: 5px;\n" +
                    "          color: #5f80b4;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card p {\n" +
                    "          color: #795548;\n" +
                    "      }\n" +
                    "\n" +
                    "      .vote-btn {\n" +
                    "          width: 15vw;\n" +
                    "          height: 10vh;\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "          margin-top: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .vote-btn:hover {\n" +
                    "          background-color: #4b6f9f;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout {\n" +
                    "          display: flex;\n" +
                    "          justify-content: right;\n" +
                    "      }\n" +
                    "  </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <div class=\"main\">\n" +
                    "          <div class=\"log-div\"> <form action=\"./logout\" method=\"get\">\n" +
                    "        <button type=\"submit\" class=\"logout-btn\">logout</button>\n" +
                    "      </form>\n</div>" +
                    "      <div class=\"create-polls\">\n" +
                    "        <div class=\"div\">\n" +
                    "<button class=\"view-active\" onclick=\"location.href='./createPoll.html'\">create Poll</button>\n"
                    +
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
                    // " <img src=\"person1.jpg\" alt=\"Person 1\" />\n" +
                    "          </div>\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(0) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(0) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"0\">\n" +
                    "<button type=\"submit\" class=\"vote-btn\" disabled>Vote</button>" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person2.jpg\" alt=\"Person 2\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(1) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(1) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"1\">\n" +
                    "<button type=\"submit\" class=\"vote-btn\" disabled>Vote</button>" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person3.jpg\" alt=\"Person 3\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(2) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(2) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"2\">\n" +
                    "<button type=\"submit\" class=\"vote-btn\" disabled>Vote</button>" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person4.jpg\" alt=\"Person 4\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(3) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(3) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"3\">\n" +
                    "<button type=\"submit\" class=\"vote-btn\" disabled>Vote</button>" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "<script>" + popupScript + "</script>\n" +
                    "</html>";
        } else {
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "  <head>\n" +
                    "    <meta charset=\"UTF-8\" />\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                    "    <title>Person Cards</title>\n" +
                    "<style>\n" +
                    "      body {\n" +
                    "        background-color: antiquewhite;\n" +
                    "          font-family: Arial, sans-serif;\n" +
                    "          display: flex;\n" +
                    "          margin-top: 5%;\n" +
                    "      }\n" +
                    "\n" +
                    "      .main {\n" +
                    "          display: grid;\n" +
                    "          gap: 20px;\n" +
                    "          max-width: 1200px;\n" +
                    "          margin: 0 auto;\n" +
                    "          background-color: #fff;\n" +
                    "          padding: 20px;\n" +
                    "          border-radius: 10px;\n" +
                    "          box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n" +
                    "      }\n" +
                    "\n" +
                    "      .card-container {\n" +
                    "          display: flex;\n" +
                    "          justify-content: space-evenly;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout-btn {\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout-btn:hover {\n" +
                    "          background-color: #4b6f9f;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls,\n" +
                    "      .div {\n" +
                    "          color: #fff;\n" +
                    "          border-radius: 5px;\n" +
                    "          padding: 10px 20px;\n" +
                    "          text-align: center;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls .view-active,\n" +
                    "      .div button {\n" +
                    "          color: black;\n" +
                    "          \n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "          margin-top: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .active-polls .view-active:hover,\n" +
                    "      .div button:hover {\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card {\n" +
                    "          width: 200px;\n" +
                    "          border: 1px solid #ccc;\n" +
                    "          border-radius: 10px;\n" +
                    "          margin: 10px;\n" +
                    "          text-align: center;\n" +
                    "          padding: 10px;\n" +
                    "          background-color: #fff;\n" +
                    "          box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                    "          display: inline-block;\n" +
                    "\n" +
                    "      }\n" +
                    "\n" +
                    "      .card img {\n" +
                    "          border-radius: 50%;\n" +
                    "          max-width: 100px;\n" +
                    "          max-height: 100px;\n" +
                    "          margin-bottom: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card h2 {\n" +
                    "          font-size: 1.2em;\n" +
                    "          margin-bottom: 5px;\n" +
                    "          color: #5f80b4;\n" +
                    "      }\n" +
                    "\n" +
                    "      .card p {\n" +
                    "          color: #795548;\n" +
                    "      }\n" +
                    "\n" +
                    "      .vote-btn {\n" +
                    "          width: 15vw;\n" +
                    "          height: 10vh;\n" +
                    "          background-color: #5f80b4; \n" +
                    "          color: #fff;\n" +
                    "          border: none;\n" +
                    "          padding: 10px 20px;\n" +
                    "          font-size: 16px;\n" +
                    "          cursor: pointer;\n" +
                    "          border-radius: 5px;\n" +
                    "          margin-top: 10px;\n" +
                    "      }\n" +
                    "\n" +
                    "      .vote-btn:hover {\n" +
                    "          background-color: #4b6f9f;\n" +
                    "      }\n" +
                    "\n" +
                    "      .logout {\n" +
                    "          display: flex;\n" +
                    "          justify-content: right;\n" +
                    "      }\n" +
                    "  </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <div class=\"main\">\n" +
                    "          <div class=\"log-div\"> <form action=\"./logout\" method=\"get\">\n" +
                    "        <button type=\"submit\" class=\"logout-btn\">logout</button>\n" +
                    "      </form>\n</div>" +
                    "      <div class=\"create-polls\">\n" +
                    "        <div class=\"div\">\n" +
                    "<button class=\"view-active\" onclick=\"location.href='./createPoll.html'\">create Poll</button>\n"
                    +
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
                    // " <img src=\"person1.jpg\" alt=\"Person 1\" />\n" +
                    "          </div>\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(0) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(0) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"0\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person2.jpg\" alt=\"Person 2\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(1) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(1) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"1\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person3.jpg\" alt=\"Person 3\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(2) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(2) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"2\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person4.jpg\" alt=\"Person 4\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(3) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(3) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"3\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\">Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "<script>" + popupScript + "</script>\n" +
                    "</html>";
        }

    }
}
