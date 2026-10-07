<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Article</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Delete Knowledge Base Article</h2>

    <p>
        Enter the Article ID you want to delete.
    </p>

    <form action="delete-article" method="post">

        <label>Article ID:</label>

        <input type="number"
               name="articleId"
               placeholder="Enter article ID"
               required>

        <button type="submit">
            Delete Article
        </button>

    </form>

    <br>

    <a href="articles">
        Back to Knowledge Base
    </a>

</div>

</body>
</html>