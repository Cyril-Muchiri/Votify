package com.votifysoft.beans;



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
                    "  .logout-btn {\n" +
                    "    width: 8vw;\n" +
                    "    justify-self: right;\n" +
                    "  }\n" +
                    "    </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <div class=\"main\">\n" +
                    "<button class=\"logout-btn\" onclick=\"location.href='./index.html'\">Logout</button>\n" +
                    "      <div class=\"active-polls\">\n" +
                    "        <div>\n" +
                    "           <form action=\"./processnames\" method=\"get\">\n" +
                    "        <button type=\"submit\" class=\"view-active\">Create a poll</button>\n" +
                    "      </form>\n" +
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
                    "            <button type=\"submit\" class=\"vote-btn\" disabled>Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person2.jpg\" alt=\"Person 2\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(1) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(1) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"1\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\"disabled>Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person3.jpg\" alt=\"Person 3\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(2) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(2) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"2\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\"disabled>Vote</button>\n" +
                    "          </form>\n" +
                    "        </div>\n" +
                    "        <div class=\"card\">\n" +
                    // " <img src=\"person4.jpg\" alt=\"Person 4\" />\n" +
                    "          <h2>" + PersonRepository.getNameAtIndex(3) + "</h2>\n" +
                    "          <p>Total Votes: " + PersonRepository.getVotesForPerson(3) + "</p>\n" +
                    "          <form action=\"./vote\" method=\"post\">\n" +
                    "            <input type=\"hidden\" name=\"personId\" value=\"3\">\n" +
                    "            <button type=\"submit\" class=\"vote-btn\"disabled>Vote</button>\n" +
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
                    "  .logout-btn {\n" +
                    "    width: 8vw;\n" +
                    "    justify-self: right;\n" +
                    "  }\n" +
                    "    </style>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <div class=\"main\">\n" +
                    "<button class=\"logout-btn\" onclick=\"location.href='./index.html'\">Logout</button>\n" +
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
