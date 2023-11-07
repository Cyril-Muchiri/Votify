package com.votifysoft.beans;

public class PollCreatorBean {
    public String createPoll(){

        return "<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "  <head>\n" +
        "    <meta charset=\"UTF-8\" />\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
        "    <title>Poll Creator</title>\n" +
        "    <style>\n" +
        "      .main {\n" +
        "        border-style: solid;\n" +
        "        height: 50vh;\n" +
        "        display: grid;\n" +
        "        align-items: center;\n" +
        "      }\n" +
        "\n" +
        "      .pollform {\n" +
        "        display: flex;\n" +
        "        flex-direction: column;\n" +
        "        align-items: center;\n" +
        "        padding: 20px;\n" +
        "        border: 2px solid #ccc;\n" +
        "        border-radius: 10px;\n" +
        "        width: 50vw;\n" +
        "      }\n" +
        "\n" +
        "      input[type=\"text\"] {\n" +
        "        margin-bottom: 15px;\n" +
        "        padding: 10px;\n" +
        "        border: 1px solid #ccc;\n" +
        "        border-radius: 5px;\n" +
        "        width: 250px;\n" +
        "        font-size: 16px;\n" +
        "      }\n" +
        "\n" +
        "      button {\n" +
        "        margin-bottom: 15px;\n" +
        "        padding: 10px 20px;\n" +
        "        border: none;\n" +
        "        border-radius: 5px;\n" +
        "        cursor: pointer;\n" +
        "        font-size: 16px;\n" +
        "      }\n" +
        "\n" +
        "      ul {\n" +
        "        list-style-type: none;\n" +
        "        padding: 0;\n" +
        "        margin: 0;\n" +
        "        font-size: 18px;\n" +
        "        margin-bottom: 15px;\n" +
        "      }\n" +
        "\n" +
        "      li {\n" +
        "        margin-bottom: 5px;\n" +
        "      }\n" +
        "\n" +
        "      .header {\n" +
        "        display: flex;\n" +
        "        justify-content: center;\n" +
        "      }\n" +
        "\n" +
        "      .pollcontainer {\n" +
        "        display: flex;\n" +
        "        justify-content: center;\n" +
        "      }\n" +
        "    </style>\n" +
        "  </head>\n" +
        "  <body>\n" +
        "    <div class=\"main\">\n" +
        "      <div class=\"header\">\n" +
        "        <h2>Add Poll participants</h2>\n" +
        "      </div>\n" +
        "      <div class=\"pollcontainer\">\n" +
        "        <div class=\"pollform\">\n" +
        "          <form id=\"nameForm\">\n" +
        "            <input type=\"text\" id=\"nameInput\" required />\n" +
        "            <button type=\"button\" onclick=\"addName()\">Add Name</button>\n" +
        "            <ul id=\"nameList\"></ul>\n" +
        "            <button type=\"button\" class=\"complete-btn\" onclick=\"completePoll()\" disabled>\n" +
        "              Complete\n" +
        "            </button>\n" +
        "          </form>\n" +
        "        </div>\n" +
        "      </div>\n" +
        "    </div>\n" +
        "\n" +
        "    <script>\n" +
        "      function addName() {\n" +
        "        var nameInput = document.getElementById(\"nameInput\").value;\n" +
        "        if (nameInput !== \"\") {\n" +
        "          var ul = document.getElementById(\"nameList\");\n" +
        "          var li = document.createElement(\"li\");\n" +
        "          li.appendChild(document.createTextNode(nameInput));\n" +
        "          ul.appendChild(li);\n" +
        "\n" +
        "          document.getElementById(\"nameInput\").value = \"\";\n" +
        "\n" +
        "          var nameCount = ul.getElementsByTagName(\"li\").length;\n" +
        "          var completeBtn = document.querySelector(\".complete-btn\");\n" +
        "          completeBtn.disabled = nameCount >= 2 ? false : true;\n" +
        "        }\n" +
        "      }\n" +
        "\n" +
        "      function completePoll() {\n" +
        "        var ul = document.getElementById('nameList');\n" +
        "        var names = [];\n" +
        "        var liElements = ul.getElementsByTagName('li');\n" +
        "        for (var i = 0; i < liElements.length; i++) {\n" +
        "          names.push(liElements[i].innerText);\n" +
        "        }\n" +
        "\n" +
        "        var formData = new FormData();\n" +
        "        for (var i = 0; i < names.length; i++) {\n" +
        "          formData.append('names', names[i]);\n" +
        "        }\n" +
        "\n" +
        "        var xhr = new XMLHttpRequest();\n" +
        "        xhr.open(\"POST\", \"./processnames\", true);\n" +
        "        xhr.onreadystatechange = function () {\n" +
        "          if (xhr.readyState === XMLHttpRequest.DONE) {\n" +
        "            if (xhr.status === 200) {\n" +
        "              alert(\"Names sent successfully!\");\n" +
        "            } else {\n" +
        "              alert(\"Error sending names: \" + xhr.status);\n" +
        "            }\n" +
        "          }\n" +
        "        };\n" +
        "        xhr.send(formData);\n" +
        "      }\n" +
        "\n" +
        "      window.onload = function () {\n" +
        "        var savedNames = JSON.parse(localStorage.getItem(\"names\"));\n" +
        "        if (savedNames) {\n" +
        "          var ul = document.getElementById(\"nameList\");\n" +
        "\n" +
        "          for (var i = 0; i < savedNames.length; i++) {\n" +
        "            var li = document.createElement(\"li\");\n" +
        "            li.appendChild(document.createTextNode(savedNames[i]));\n" +
        "            ul.appendChild(li);\n" +
        "          }\n" +
        "\n" +
        "          var nameCount = ul.getElementsByTagName(\"li\").length;\n" +
        "          var completeBtn = document.querySelector(\".complete-btn\");\n" +
        "          completeBtn.disabled = nameCount >= 2 ? false : true;\n" +
        "        }\n" +
        "      };\n" +
        "    </script>\n" +
        "  </body>\n" +
        "</html>";
    
    }
}
