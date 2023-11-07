package com.votifysoft.beans;

import com.votifysoft.repository.PersonRepository;

public class NewPoll {
    public static String showNewPoll(){
        return "<div class=\"card\">\n" +
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
                    "      </div>\n" +"";
    }
}
