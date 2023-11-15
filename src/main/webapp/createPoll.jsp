<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Poll Creator</title>
    <style>
        <!-- Your existing styles here -->
    </style>
</head>
<body>
    <div class="main">
        <div class="header">
            <h2>Add Poll participants</h2>
        </div>
        <div class="pollcontainer">
            <div class="pollform">
                <form id="nameForm">
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

    <script>
        function addName() {
            var nameInput = document.getElementById("nameInput").value;
            if (nameInput !== "") {
                var ul = document.getElementById("nameList");
                var li = document.createElement("li");
                li.appendChild(document.createTextNode(nameInput));
                ul.appendChild(li);

                document.getElementById("nameInput").value = "";

                var nameCount = ul.getElementsByTagName("li").length;
                var completeBtn = document.querySelector(".complete-btn");
                completeBtn.disabled = nameCount >= 2 ? false : true;

                // Store names in session
                var namesInSession = '<%=(ArrayList<String>)session.getAttribute("namesInSession") %>';
                namesInSession = namesInSession || [];
                namesInSession.push(nameInput);
                session.setAttribute("namesInSession", namesInSession);
            }
        }

        function completePoll() {
            var ul = document.getElementById('nameList');
            var names = [];
            var liElements = ul.getElementsByTagName('li');
            for (var i = 0; i < liElements.length; i++) {
                names.push(liElements[i].innerText);
            }

            var namesInSession = '<%=(ArrayList<String>)session.getAttribute("namesInSession") %>';
            namesInSession = namesInSession || [];
            names = names.concat(namesInSession);

            
        }

        window.onload = function () {
            // Load names from session on page load
            var namesInSession = '<%=(ArrayList<String>)session.getAttribute("namesInSession") %>';
            namesInSession = namesInSession || [];
            var ul = document.getElementById("nameList");

            for (var i = 0; i < namesInSession.length; i++) {
                var li = document.createElement("li");
                li.appendChild(document.createTextNode(namesInSession[i]));
                ul.appendChild(li);
            }

            var nameCount = ul.getElementsByTagName("li").length;
            var completeBtn = document.querySelector(".complete-btn");
            completeBtn.disabled = nameCount >= 2 ? false : true;
        };
    </script>
</body>
</html>
