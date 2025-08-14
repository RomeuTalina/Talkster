const signupForm = document.getElementById("signupForm");

signupForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const csrfToken = document.getElementById("csrfToken").value;

    const response = await fetch("/signup", {
        method: "POST",
        headers: { 
            "Content-Type": "application/x-www-form-urlencoded",
            "X-CSRF-TOKEN": csrfToken
        },
        body: new URLSearchParams({ username, password })
    });

    if (response.ok) {
        window.location.href = "/login";
    } else {
        alert("Signup failed. Please try again.");
    }
});
