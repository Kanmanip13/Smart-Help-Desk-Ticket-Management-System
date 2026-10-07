<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Delete Ticket</title>

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
        Delete Ticket
    </h1>

    <p class="page-subtitle">
        Remove a ticket from the system.
    </p>


    <!-- ================= DELETE FORM ================= -->

    <div class="form-card">

        <h2 style="margin-bottom: 15px;">
            Delete Ticket
        </h2>

        <p class="page-subtitle">
            Enter the Ticket ID that you want to delete.
        </p>

        <form action="delete-ticket" method="post">

            <label for="ticketId">
                Ticket ID
            </label>

            <input
                type="number"
                id="ticketId"
                name="ticketId"
                placeholder="Enter ticket ID"
                required>

            <button
                type="submit"
                class="btn btn-danger"
                onclick="return confirm('Are you sure you want to delete this ticket?');">

                Delete Ticket

            </button>

            <a
                href="tickets"
                class="btn">

                Cancel

            </a>

        </form>

    </div>

</div>

</body>
</html>