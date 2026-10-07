<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Knowledge Base Article</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Add Knowledge Base Article</h2>

    <form action="add-article" method="post">

        <label>Title:</label>

        <input type="text"
               name="title"
               placeholder="Enter article title"
               required>

        <label>Content:</label>

        <textarea name="content"
                  placeholder="Enter article content"
                  required></textarea>

        <label>Category:</label>

        <input type="text"
               name="category"
               placeholder="Enter category"
               required>

        <button type="submit">
            Add Article
        </button>

    </form>

    <br>

    <a href="articles">
        Back to Knowledge Base
    </a>

</div>

</body>
</html>