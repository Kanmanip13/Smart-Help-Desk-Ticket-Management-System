<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Update User</title>

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
        Update User Role
    </h1>

    <p class="page-subtitle">
        Change the role of an existing user.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="update-user" method="post">


            <!-- User ID -->

            <label for="userId">
                User ID
            </label>

            <input
                type="number"
                id="userId"
                name="userId"
                placeholder="Enter user ID"
                required>


            <!-- Role -->

            <label for="role">
                New Role
            </label>

            <select
                id="role"
                name="role"
                required>

                <option value="">
                    Select Role
                </option>

                <option value="Admin">
                    Admin
                </option>

                <option value="Agent">
                    Agent
                </option>

                <option value="User">
                    User
                </option>

            </select>


            <!-- Buttons -->

            <button
                type="submit"
                class="btn">

                Update Role

            </button>


            <a
                href="users"
                class="btn">

                Cancel

            </a>

        </form>

    </div>


    <!-- ================= INFORMATION ================= -->

    <div class="content-card">

        <h2>
            Role Information
        </h2>

        <p class="page-subtitle">
            Choose the appropriate role for the user.
        </p>

        <p>
            <strong>Admin:</strong>
            Manages users, tickets, comments and knowledge base.
        </p>

        <br>

        <p>
            <strong>Agent:</strong>
            Handles tickets assigned by the administrator.
        </p>

        <br>

        <p>
            <strong>User:</strong>
            Creates and tracks their own support tickets.
        </p>

    </div>

</div>

</body>

</html>