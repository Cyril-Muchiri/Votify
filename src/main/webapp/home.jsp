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
        <jsp:include page="./homestyle.jsp" />
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
    var voteSuccessMessage = "<%= session.getAttribute("voteSuccessMessage") %>";

    if (voteSuccessMessage) {
        alert(voteSuccessMessage);
         <% session.removeAttribute("voteSuccessMessage"); %>
    }
</script>
</html>
