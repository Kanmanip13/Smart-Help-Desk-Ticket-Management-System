<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Create Ticket</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<div class="navbar">

    <div class="logo">
        Smart Help Desk
    </div>

    <div class="nav-links">

        <a href="user-dashboard">
            Dashboard
        </a>

        <a href="tickets">
            My Tickets
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
        Create New Ticket
    </h1>

    <p class="page-subtitle">
        Submit your issue to the support team.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="create-ticket" method="post">

            <label for="title">
                Ticket Title
            </label>

            <input
                type="text"
                id="title"
                name="title"
                placeholder="Enter your issue title"
                required>


            <label for="description">
                Description
            </label>

            <textarea
                id="description"
                name="description"
                placeholder="Describe your issue in detail"
                required></textarea>


            <label for="priority">
                Priority
            </label>

            <select
                id="priority"
                name="priority"
                required>

                <option value="">
                    Select Priority
                </option>

                <option value="Low">
                    Low
                </option>

                <option value="Medium">
                    Medium
                </option>

                <option value="High">
                    High
                </option>

            </select>


            <label for="status">
                Status
            </label>

            <select
                id="status"
                name="status"
                required>

                <option value="Open">
                    Open
                </option>

                <option value="In Progress">
                    In Progress
                </option>

                <option value="Resolved">
                    Resolved
                </option>

            </select>


            <button
                type="submit"
                class="btn">

                Create Ticket

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