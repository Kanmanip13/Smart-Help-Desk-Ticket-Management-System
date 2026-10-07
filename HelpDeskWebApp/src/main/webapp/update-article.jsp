<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Article</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Update Knowledge Base Article</h2>

    <form action="update-article" method="post">

        <label>Article ID:</label>

        <input type="number"
               name="articleId"
               placeholder="Enter article ID"
               required>

        <label>Title:</label>

        <input type="text"
               name="title"
               placeholder="Enter new title"
               required>

        <label>Content:</label>

        <textarea name="content"
                  placeholder="Enter new content"
                  required></textarea>

        <label>Category:</label>

        <input type="text"
               name="category"
               placeholder="Enter category"
               required>

        <button type="submit">
            Update Article
        </button>

    </form>

    <br>

    <a href="articles">
        Back to Knowledge Base
    </a>

</div>

</body>
</html>