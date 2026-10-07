<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Comment</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Delete Comment</h2>

    <p>
        Enter the Comment ID you want to delete.
    </p>

    <form action="delete-comment" method="post">

        <label>Comment ID:</label>

        <input type="number"
               name="commentId"
               placeholder="Enter comment ID"
               required>

        <button type="submit">
            Delete Comment
        </button>

    </form>

    <br>

    <a href="tickets">
        Back to Tickets
    </a>

</div>

</body>
</html>