const commentForm = document.getElementById("commentForm");

console.log("js on")

commentForm.addEventListener("submit", async (e) => {
    console.log("Event Listener on")
    e.preventDefault();   

    const authorName = document.getElementById("authorUsername").value;
    const commentBody = document.getElementById("commentBody").value;
    const csrfToken = document.getElementById("csrfToken").value;

    const requestBody = {
        "authorName": authorName,
        "body": commentBody,
    }

    const currentPath = window.location.pathname;
    const pathId = window.location.pathname.split("/")[2];

    const response = await fetch(`/api/post/${pathId}/comment`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "X-CSRF-TOKEN": csrfToken
        },
        body: JSON.stringify(requestBody)
    });

    if(response.ok){
        window.location.href = currentPath;
    } 
    else {
        alert("Couldn't send your comment, please try again later.") 
    }
})
