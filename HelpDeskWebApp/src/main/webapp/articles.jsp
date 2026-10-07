<%@ page import="java.util.List" %>
<%@ page import="com.helpdesk.model.KBArticle" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Smart Help Desk - Knowledge Base</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Knowledge Base</h2>

    <table>

        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Category</th>
            <th>Created Date</th>
        </tr>

        <%
            List<KBArticle> articles =
                (List<KBArticle>) request.getAttribute("articles");

            if (articles != null && !articles.isEmpty()) {

                for (KBArticle article : articles) {
        %>

        <tr>
            <td><%= article.getArticleId() %></td>

            <td><%= article.getTitle() %></td>

            <td><%= article.getContent() %></td>

            <td><%= article.getCategory() %></td>

            <td><%= article.getCreatedDate() %></td>
        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="5">
                No knowledge base articles found.
            </td>
        </tr>

        <%
            }
        %>

    </table>

    <br>

    <a href="add-article.jsp">
        Add Article
    </a>

    <br><br>

    <a href="admin-dashboard.jsp">
        Back to Admin Dashboard
    </a>

</div>

</body>
</html>