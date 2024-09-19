/**
document.getElementById("loginForm").addEventListener("submit", function() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Hardcoded credentials (for demonstration only)
    const validUsername = "user";
    const validPassword = "password123";

    if (username === validUsername && password === validPassword) {
        window.location.href = "mainpage.html"; // Redirect to a "dashboard" page
    } else {
        document.getElementById("error-message").textContent = "Invalid username or password!";
    }
});
**/

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("dropDown").classList.toggle("show")

    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
              var openDropdown = dropdowns[i];
              if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
              }
            }
        }
    }
});

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("loginForm").addEventListener("submit", function(event) {
        event.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        window.location.href = "mainpage.html";
    });
});

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("clickMeButton").addEventListener("click", function() {
        alert("You clicked the button!");
    });
});

