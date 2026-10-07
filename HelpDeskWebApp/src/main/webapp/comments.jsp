<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.helpdesk.model.Comment" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Smart Help Desk - Comments</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h1>Smart Help Desk</h1>

    <h2>Ticket Comments</h2>

    <%
        String ticketId =
            request.getParameter("ticketId");
    %>

    <p>
        Ticket ID:
        <strong><%= ticketId %></strong>
    </p>

    <%
        List<Comment> comments =
            (List<Comment>) request.getAttribute("comments");

        Map<Integer, String> userNames =
            (Map<Integer, String>)
            request.getAttribute("userNames");
    %>

    <%
        if (comments != null && !comments.isEmpty()) {
    %>

    <table>

        <tr>
            <th>Comment ID</th>
            <th>User</th>
            <th>Comment</th>
            <th>Date</th>
        </tr>

        <%
            for (Comment comment : comments) {

                String userName = "Unknown User";

                if (userNames != null &&
                    userNames.containsKey(comment.getUserId())) {

                    userName =
                        userNames.get(comment.getUserId());
                }
        %>

        <tr>

            <td>
                <%= comment.getCommentId() %>
            </td>

            <td>
                <%= userName %>
            </td>

            <td>
                <%= comment.getCommentText() %>
            </td>

            <td>
                <%= comment.getCommentDate() %>
            </td>

        </tr>

        <%
            }
        %>

    </table>

    <%
        } else {
    %>

    <p>No comments found for this ticket.</p>

    <%
        }
    %>

    <br>

    <a href="add-comment.jsp">
        Add Comment
    </a>

    <br><br>

    <a href="tickets">
        Back to Tickets
    </a>

</div>

</body>
</html>