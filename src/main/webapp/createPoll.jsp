<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Poll Creator</title>
    <style>
           <%@ include file="pollcss.jsp" %>
    </style>
    <script>
      <%@ include file="pollscript.jsp" %>
</script>

</head>
<body>
    <div class="main">
        <div class="header">
            <h2>Add Poll participants</h2>
        </div>
        <div class="pollcontainer">
            <div class="pollform">
             <form id="nameForm" action="./newPoll" method="post">
    <input type="text" id="nameInput" required />
    <button type="button" onclick="addName()">Add Name</button>
    <br>
    <ul id="nameList"></ul>
    <button type="button" class="complete-btn" onclick="completePoll()" disabled>
        Complete
    </button>
</form>

            </div>
        </div>
    </div>
</body>
</html>
