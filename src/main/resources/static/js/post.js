const form = document.getElementById("postForm");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const authorUsername = document.getElementById("authorUsername").value;
    const body = document.getElementById("body").value;
    const csrfToken = document.getElementById("csrfToken").value;

    const postData = {
        authorUsername: authorUsername,
        body: body
    }

    const response = await fetch("/api/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "X-CSRF-TOKEN": csrfToken
        },
        body: JSON.stringify(postData)
    });

    if(response.ok){
        window.location.href = "/dashboard";
    }
    else {
        alert("We couldn't create your post, please try again later.");
    }
});

postBody.addEventListener("keydown", async (e) => {
    if (e.key === "Enter" && e.ctrlKey) {
        e.preventDefault(); // prevent new line for Ctrl+Enter
        postForm.requestSubmit(); // submit the form
    }
});
