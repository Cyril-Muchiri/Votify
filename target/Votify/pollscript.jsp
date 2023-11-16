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