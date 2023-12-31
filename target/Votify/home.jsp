<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Person Cards</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <style>
    <%@ include file="homestyle.jsp" %>
    </style>
</head>
<body>

    <div class="main">
        <div class="log-div">
            <form action="${pageContext.request.contextPath}/logout" method="get">
                <button type="submit" class="logout-btn">logout</button>
            </form>
        </div>
        <div class="create-polls">
            <div class="div">
            <form action="./newPoll" method="get">
                <button class="view-active" type="submit">create Poll</button>
                </form>
            </div>
        </div>
        <div class="active-polls">
            <div class="div">
                <button class="view-active">View Active Polls</button>
            </div>
        </div>
        <div class="card-container">
            <c:forEach var="index" begin="0" end="3">
                <div class="card">
                    <%-- <div class="image">
                        <!-- <img src="person${index + 1}.jpg" alt="Person ${index + 1}" /> -->
                    </div> --%>
                    <%@ page import="com.votifysoft.repository.PersonRepository" %>
                 <c:set var="personName" value="${PersonRepository.getNameAtIndex(index)}" />
                    <h2>${personName}</h2>
                    <p>Total Votes: ${PersonRepository.getVotesForPerson(index)}</p>
                   <c:choose>
           <c:when test="${sessionScope.hasVoted}">
                <form action="./vote" method="post">
                    <input type="hidden" name="personId" value="${index}">
                    <button type="submit" class="vote-btn" disabled>Already Voted</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="./vote" method="post">
                    <input type="hidden" name="personId" value="${index}">
                    <button type="submit" class="vote-btn">Vote</button>
                </form>
   
            </c:otherwise>
        </c:choose>
                </div>
            </c:forEach>
        </div>
        ${requestScope.cardContainerHTML}
        
    </div>
    <script>
    <% Boolean hasVoted = (Boolean) session.getAttribute("hasVoted"); %>
    <% if (hasVoted != null && hasVoted) { %>
        alert('You have voted successfully!');
    <% } %>
</script>
</body>
  
</html>
