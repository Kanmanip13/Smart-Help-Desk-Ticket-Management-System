<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Add Comment</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<div class="navbar">

    <div class="logo">
        Smart Help Desk
    </div>

    <div class="nav-links">

        <a href="admin-dashboard.jsp">
            Dashboard
        </a>

        <a href="tickets">
            Tickets
        </a>

        <a href="users">
            Users
        </a>

        <a href="articles">
            Knowledge Base
        </a>

        <a href="logout">
            Logout
        </a>

    </div>

</div>


<!-- ================= MAIN CONTENT ================= -->

<div class="main-content">

    <h1 class="page-title">
        Add Comment
    </h1>

    <p class="page-subtitle">
        Add a comment to a support ticket.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="add-comment" method="post">


            <!-- Ticket ID -->

            <label for="ticketId">
                Ticket ID
            </label>

            <input
                type="number"
                id="ticketId"
                name="ticketId"
                placeholder="Enter ticket ID"
                required>


            <!-- Comment -->

            <label for="commentText">
                Comment
            </label>

            <textarea
                id="commentText"
                name="commentText"
                placeholder="Enter your comment"
                required></textarea>


            <!-- Submit -->

            <button
                type="submit"
                class="btn">

                Add Comment

            </button>


            <a
                href="tickets"
                class="btn">

                Cancel

            </a>

        </form>

    </div>


    <!-- ================= INFORMATION ================= -->

    <div class="content-card">

        <h2>
            Comment Guidelines
        </h2>

        <p class="page-subtitle">
            Use comments to communicate about the ticket.
        </p>

        <p>
            <strong>Admin:</strong>
            Can add comments to any ticket.
        </p>

        <br>

        <p>
            <strong>Agent:</strong>
            Can comment on tickets assigned to them.
        </p>

        <br>

        <p>
            <strong>User:</strong>
            Can comment on tickets created by them.
        </p>

    </div>

</div>

</body>

</html>