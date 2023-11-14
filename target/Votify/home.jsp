<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %>
<%@ page import="com.votifysoft.repository.PersonRepository" %>
<%@ page import="com.votifysoft.voter.Person" %>

<%
    boolean hasVoted = (Boolean) session.getAttribute("hasVoted");
    List<Person> persons = PersonRepository.getPersons();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Person Cards</title>
    <style>
        body {
            background-color: antiquewhite;
            font-family: Arial, sans-serif;
            display: flex;
            margin-top: 5%;
        }

        .main {
            display: grid;
            gap: 20px;
            max-width: 1200px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .card-container {
            display: flex;
            justify-content: space-evenly;
        }

        .logout-btn {
            background-color: #5f80b4;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }

        .logout-btn:hover {
            background-color: #4b6f9f;
        }

        .active-polls,
        .div {
            color: #fff;
            border-radius: 5px;
            padding: 10px 20px;
            text-align: center;
        }

        .active-polls .view-active,
        .div button {
            color: black;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

        .active-polls .view-active:hover,
        .div button:hover {
            background-color: #5f80b4;
            color: #fff;
        }

        .card {
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px;
            text-align: center;
            padding: 10px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        .card img {
            border-radius: 50%;
            max-width: 100px;
            max-height: 100px;
            margin-bottom: 10px;
        }

        .card h2 {
            font-size: 1.2em;
            margin-bottom: 5px;
            color: #5f80b4;
        }

        .card p {
            color: #795548;
        }

        .vote-btn {
            width: 15vw;
            height: 10vh;
            background-color: #5f80b4;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

        .vote-btn:hover {
            background-color: #4b6f9f;
        }

        .logout {
            display: flex;
            justify-content: right;
        }
    </style>
</head>
<body>
    <div class="main">
        <div class="logout">
            <form action="./logout" method="get">
                <button type="submit" class="logout-btn">logout</button>
            </form>
        </div>
        <div class="create-polls">
            <div class="div">
                <button class="view-active" onclick="location.href='./createPoll.html'">create Poll</button>
            </div>
        </div>
        <div class="active-polls">
            <div class="div">
                <button class="view-active">View Active Polls</button>
            </div>
        </div>
        <div class="card-container">
        <div class="cont"></div>
            <% for (int i = 0; i < persons.size(); i++) {
        Person person = persons.get(i);
    %>
                   <div class="card">
            <div class="image">
                <!-- You may add an image if available -->
            </div>
            <h2><%= person.getName() %></h2>
            <p>Total Votes: <%= PersonRepository.getVotesForPerson(person.getId()) %></p>
            <form action="./vote" method="post">
                <input type="hidden" name="personId" value="<%= person.getId() %>">
                <%
                    String disabledClass = hasVoted ? "disabled-vote-btn" : "";
                    String disabledAttribute = hasVoted ? "disabled" : "";
                %>
                <button type="submit" class="vote-btn <%= disabledClass %>" <%= disabledAttribute %>>Vote</button>
            </form>
        </div>
    <% } %>
        </div>
            
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    // Check if the voteSuccessMessage is present in the session
    var voteSuccessMessage = "<%= session.getAttribute("voteSuccessMessage") %>";

    if (voteSuccessMessage) {
        // Display a popup with the success message
        alert(voteSuccessMessage);
        
        // Clear the message attribute from the session to avoid showing the popup on page reload
         <% session.removeAttribute("voteSuccessMessage"); %>
    }
</script>
</html>
