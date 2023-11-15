<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .div {
            color: #fff;
            border-radius: 5px;
            padding: 10px 20px;
            text-align: center;
        }

        .div button {
            color: black;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

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
        <div class="log-div">
            <form action="${pageContext.request.contextPath}/logout" method="get">
                <button type="submit" class="logout-btn">logout</button>
            </form>
        </div>
        <div class="create-polls">
            <div class="div">
                <button class="view-active" onclick="location.href='${pageContext.request.contextPath}/createPoll.html'">create Poll</button>
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
    </div>
</body>
</html>
