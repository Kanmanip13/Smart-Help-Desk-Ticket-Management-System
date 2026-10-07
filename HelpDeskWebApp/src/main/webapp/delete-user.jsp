<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Delete User</title>

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
        Delete User
    </h1>

    <p class="page-subtitle">
        Remove a user from the Smart Help Desk system.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <h2 style="margin-bottom: 15px;">
            Delete User
        </h2>

        <p class="page-subtitle">
            Enter the User ID that you want to delete.
        </p>


        <form action="delete-user" method="post">

            <label for="userId">
                User ID
            </label>

            <input
                type="number"
                id="userId"
                name="userId"
                placeholder="Enter user ID"
                required>


            <button
                type="submit"
                class="btn btn-danger"
                onclick="return confirm('Are you sure you want to delete this user?');">

                Delete User

            </button>


            <a
                href="users"
                class="btn">

                Cancel

            </a>

        </form>

    </div>


    <!-- ================= WARNING ================= -->

    <div class="content-card">

        <h2>
            Important
        </h2>

        <p class="page-subtitle">
            Deleting a user permanently removes that user from the system.
        </p>

        <p>
            Please verify the User ID before deleting.
        </p>

    </div>

</div>

</body>

</html>