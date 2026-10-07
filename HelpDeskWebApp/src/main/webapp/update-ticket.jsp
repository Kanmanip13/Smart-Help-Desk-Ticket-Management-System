<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Update Ticket</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<div class="navbar">

    <div class="logo">
        Smart Help Desk
    </div>

    <div class="nav-links">

        <a href="tickets">
            Tickets
        </a>

        <a href="create-ticket.jsp">
            Create Ticket
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
        Update Ticket Status
    </h1>

    <p class="page-subtitle">
        Update the status of a support ticket.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="update-ticket" method="post">

            <label for="ticketId">
                Ticket ID
            </label>

            <input
                type="number"
                id="ticketId"
                name="ticketId"
                placeholder="Enter ticket ID"
                required>


            <label for="status">
                New Status
            </label>

            <select
                id="status"
                name="status"
                required>

                <option value="">
                    Select Status
                </option>

                <option value="Open">
                    Open
                </option>

                <option value="In Progress">
                    In Progress
                </option>

                <option value="Resolved">
                    Resolved
                </option>

                <option value="Closed">
                    Closed
                </option>

            </select>


            <button
                type="submit"
                class="btn">

                Update Status

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