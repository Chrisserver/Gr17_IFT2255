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

function onChangeEvent() {
	var selectOption = document.getElementById("idUtilisateur").value;
	var result = document.getElementById("utilisateur-label");
	if (selectOption == "Resident") {
		var english = document.getElementById("resident").value;
		result.innerHTML = resident;
	} else if (selectOption == "Intervenant") {
		var germen = document.getElementById("intervenant").value;
		result.innerHTML = intervenant;
	}
}

document.addEventListener("DOMContentLoaded", function() {
    function myFunction() {
      document.getElementById("myDropdown").classList.toggle("show");
    }

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
    document.getElementById("boutonDeconnexion").addEventListener("click", function() {
        alert("Vous êtes déconnecté");
    });
});

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("clickMeButton").addEventListener("click", function() {
        alert("Nous aussi!");
    });    
});

