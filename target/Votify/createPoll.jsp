<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Poll Creator</title>
    <style>
        .main {
            border-style: solid;
            height: 50vh;
            display: grid;
            align-items: center;
        }

        .pollform {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            border: 2px solid #ccc;
            border-radius: 10px;
            width: 50vw;
        }

        input[type="text"] {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 250px;
            font-size: 16px;
        }

        button {
            margin-bottom: 15px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            font-size: 18px;
            margin-bottom: 15px;
        }

        li {
            margin-bottom: 5px;
        }

        .header {
            display: flex;
            justify-content: center;
        }

        .pollcontainer {
            display: flex;
            justify-content: center;
        }
    </style>
    <script>
      function addName() {
            var nameInput = document.getElementById("nameInput").value;
            if (nameInput.trim() !== "") {
                var ul = document.getElementById("nameList");
                var li = document.createElement("li");
                li.appendChild(document.createTextNode(nameInput));
                ul.appendChild(li);

                document.getElementById("nameInput").value = "";

                var nameCount = ul.getElementsByTagName("li").length;
                var completeBtn = document.querySelector(".complete-btn");
                completeBtn.disabled = nameCount >= 2 ? false : true;
            }
        }
    function completePoll() {
        var ul = document.getElementById('nameList');
        var names = [];
        var liElements = ul.getElementsByTagName('li');
        for (var i = 0; i < liElements.length; i++) {
            names.push(liElements[i].innerText);
        }

        // Add names to a hidden input field in the form
        var hiddenInput = document.createElement('input');
        hiddenInput.type = 'hidden';
        hiddenInput.name = 'names';
           hiddenInput.value = names.join(',');

        var form = document.getElementById('nameForm');
        form.appendChild(hiddenInput);

        form.submit();
    }
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
