<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Create User</title>

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
        Create New User
    </h1>

    <p class="page-subtitle">
        Add a new user to the Smart Help Desk system.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="create-user" method="post">

            <!-- Name -->

            <label for="name">
                Full Name
            </label>

            <input
                type="text"
                id="name"
                name="name"
                placeholder="Enter full name"
                required>


            <!-- Email -->

            <label for="email">
                Email Address
            </label>

            <input
                type="email"
                id="email"
                name="email"
                placeholder="Enter email address"
                required>


            <!-- Role -->

            <label for="role">
                User Role
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

                Create User

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
            User Roles
        </h2>

        <p class="page-subtitle">
            Select the appropriate role for the new user.
        </p>

        <p>
            <strong>Admin:</strong>
            Can manage the complete help desk system.
        </p>

        <br>

        <p>
            <strong>Agent:</strong>
            Can handle tickets assigned by an administrator.
        </p>

        <br>

        <p>
            <strong>User:</strong>
            Can create and track their own support tickets.
        </p>

    </div>

</div>

</body>

</html>