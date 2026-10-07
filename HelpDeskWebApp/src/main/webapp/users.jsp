<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.helpdesk.model.User" %>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Users</title>

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
        User Management
    </h1>

    <p class="page-subtitle">
        View and manage users registered in the Smart Help Desk system.
    </p>


    <!-- ================= ACTION ================= -->

    <div style="margin-bottom: 20px;">

        <a href="create-user.jsp" class="btn">
            Create New User
        </a>

        <a href="admin-dashboard.jsp" class="btn">
            Back to Dashboard
        </a>

    </div>


    <!-- ================= USER TABLE ================= -->

    <div class="content-card">

        <h2>
            All Users
        </h2>

        <table>

            <thead>

                <tr>

                    <th>
                        User ID
                    </th>

                    <th>
                        Name
                    </th>

                    <th>
                        Email
                    </th>

                    <th>
                        Role
                    </th>

                    <th>
                        Actions
                    </th>

                </tr>

            </thead>


            <tbody>

                <%
                    if (users != null && !users.isEmpty()) {

                        for (User user : users) {
                %>

                <tr>

                    <td>
                        <%= user.getUserId() %>
                    </td>

                    <td>
                        <%= user.getName() %>
                    </td>

                    <td>
                        <%= user.getEmail() %>
                    </td>

                    <td>
                        <%= user.getRole() %>
                    </td>

                    <td>

                        <a
                            href="update-user.jsp?userId=<%= user.getUserId() %>"
                            class="btn">

                            Edit Role

                        </a>


                        <a
                            href="delete-user.jsp?userId=<%= user.getUserId() %>"
                            class="btn btn-danger">

                            Delete

                        </a>

                    </td>

                </tr>

                <%
                        }

                    } else {
                %>

                <tr>

                    <td colspan="5" style="text-align: center;">

                        No users found.

                    </td>

                </tr>

                <%
                    }
                %>

            </tbody>

        </table>

    </div>


    <!-- ================= ROLE INFORMATION ================= -->

    <div class="content-card">

        <h2>
            User Roles
        </h2>

        <p class="page-subtitle">
            The system supports three different roles.
        </p>

        <p>
            <strong>Admin:</strong>
            Manages tickets, users, comments and knowledge base.
        </p>

        <p>
            <strong>Agent:</strong>
            Handles tickets assigned by the administrator.
        </p>

        <p>
            <strong>User:</strong>
            Creates and tracks their own support tickets.
        </p>

    </div>

</div>


</body>

</html>