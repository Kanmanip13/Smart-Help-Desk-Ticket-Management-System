<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.helpdesk.model.Login" %>

<%
    Login loginUser = (Login) session.getAttribute("loginUser");

    if (loginUser == null ||
        !"Agent".equals(loginUser.getRole())) {

        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Agent Dashboard</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- ================= NAVBAR ================= -->

<div class="navbar">

    <div class="logo">
        Smart Help Desk
    </div>

    <div class="nav-links">

        <a href="agent-dashboard">
            Dashboard
        </a>

        <a href="tickets">
            My Tickets
        </a>

        <a href="add-comment.jsp">
            Comments
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
        Agent Dashboard
    </h1>

    <p class="page-subtitle">
        Welcome back,
        <strong><%= loginUser.getUsername() %></strong> 👋
    </p>


    <!-- ================= DASHBOARD CARDS ================= -->

    <div class="dashboard-cards">

        <!-- My Tickets -->

        <div class="dashboard-card">

            <h3>My Tickets</h3>

            <div class="number">
                🎫
            </div>

        </div>


        <!-- Ticket Status -->

        <div class="dashboard-card">

            <h3>Ticket Status</h3>

            <div class="number">
                ✓
            </div>

        </div>


        <!-- Comments -->

        <div class="dashboard-card">

            <h3>Comments</h3>

            <div class="number">
                💬
            </div>

        </div>


        <!-- Role -->

        <div class="dashboard-card">

            <h3>Role</h3>

            <div class="number">
                Agent
            </div>

        </div>

    </div>


    <!-- ================= TICKET MANAGEMENT ================= -->

    <div class="content-card">

        <h2>Ticket Management</h2>

        <p class="page-subtitle">
            View and manage tickets assigned to you.
        </p>

        <a href="tickets" class="btn">
            View My Tickets
        </a>

        <a href="update-ticket.jsp" class="btn">
            Update Ticket Status
        </a>

    </div>


    <!-- ================= COMMENTS ================= -->

    <div class="content-card">

        <h2>Comments</h2>

        <p class="page-subtitle">
            Add comments to tickets assigned to you.
        </p>

        <a href="add-comment.jsp" class="btn">
            Add Comment
        </a>

    </div>


    <!-- ================= KNOWLEDGE BASE ================= -->

    <div class="content-card">

        <h2>Knowledge Base</h2>

        <p class="page-subtitle">
            View available support articles.
        </p>

        <a href="articles" class="btn">
            View Knowledge Base
        </a>

    </div>

</div>

</body>
</html>