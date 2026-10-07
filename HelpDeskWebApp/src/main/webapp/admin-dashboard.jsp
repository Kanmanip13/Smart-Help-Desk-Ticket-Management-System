<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.helpdesk.model.Login" %>
<%@ page import="com.helpdesk.service.TicketService" %>
<%@ page import="com.helpdesk.service.UserService" %>
<%@ page import="com.helpdesk.service.CommentService" %>

<%
    Login loginUser = (Login) session.getAttribute("loginUser");

    if (loginUser == null ||
        !"Admin".equalsIgnoreCase(loginUser.getRole())) {

        response.sendRedirect("login.jsp");
        return;
    }

    TicketService ticketService = new TicketService();
    UserService userService = new UserService();
    CommentService commentService = new CommentService();

    int totalTickets = ticketService.getTotalTickets();
    int totalUsers = userService.getTotalUsers();
    int totalComments = commentService.getTotalComments();

    int openTickets =
            ticketService.getTicketsByStatus("Open");

    int progressTickets =
            ticketService.getTicketsByStatus("In Progress");

    int resolvedTickets =
            ticketService.getTicketsByStatus("Resolved");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Admin Dashboard</title>

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
        Admin Dashboard
    </h1>

    <p class="page-subtitle">

        Welcome back,
        <strong><%= loginUser.getUsername() %></strong>
        👋

    </p>


    <!-- ================= STATISTICS ================= -->

    <div class="dashboard-cards">

        <!-- Total Tickets -->

        <div class="dashboard-card">

            <h3>
                Total Tickets
            </h3>

            <div class="number">
                <%= totalTickets %>
            </div>

        </div>


        <!-- Total Users -->

        <div class="dashboard-card">

            <h3>
                Total Users
            </h3>

            <div class="number">
                <%= totalUsers %>
            </div>

        </div>


        <!-- Total Comments -->

        <div class="dashboard-card">

            <h3>
                Total Comments
            </h3>

            <div class="number">
                <%= totalComments %>
            </div>

        </div>


        <!-- Open Tickets -->

        <div class="dashboard-card">

            <h3>
                Open Tickets
            </h3>

            <div class="number">
                <%= openTickets %>
            </div>

        </div>


        <!-- In Progress -->

        <div class="dashboard-card">

            <h3>
                In Progress
            </h3>

            <div class="number">
                <%= progressTickets %>
            </div>

        </div>


        <!-- Resolved -->

        <div class="dashboard-card">

            <h3>
                Resolved Tickets
            </h3>

            <div class="number">
                <%= resolvedTickets %>
            </div>

        </div>


        <!-- System Status -->

        <div class="dashboard-card">

            <h3>
                System Status
            </h3>

            <div class="number">
                Active
            </div>

        </div>

    </div>


    <!-- ================= TICKET MANAGEMENT ================= -->

    <div class="content-card">

        <h2>
            Ticket Management
        </h2>

        <p class="page-subtitle">

            Create, view, update, delete and assign support tickets.

        </p>


        <a href="tickets" class="btn">
            View All Tickets
        </a>

        <a href="create-ticket.jsp" class="btn">
            Create Ticket
        </a>

        <a href="update-ticket.jsp" class="btn">
            Update Ticket Status
        </a>

        <a href="delete-ticket.jsp" class="btn btn-danger">
            Delete Ticket
        </a>

        <a href="assign-ticket" class="btn btn-success">
            Assign Ticket to Agent
        </a>

    </div>


    <!-- ================= USER MANAGEMENT ================= -->

    <div class="content-card">

        <h2>
            User Management
        </h2>

        <p class="page-subtitle">

            Manage users and their roles in the help desk system.

        </p>


        <a href="users" class="btn">
            View All Users
        </a>

        <a href="create-user.jsp" class="btn">
            Create User
        </a>

        <a href="update-user.jsp" class="btn">
            Update User Role
        </a>

        <a href="delete-user.jsp" class="btn btn-danger">
            Delete User
        </a>

    </div>


    <!-- ================= COMMENT MANAGEMENT ================= -->

    <div class="content-card">

        <h2>
            Comment Management
        </h2>

        <p class="page-subtitle">

            Manage comments related to support tickets.

        </p>


        <a href="add-comment.jsp" class="btn">
            Add Comment
        </a>

        <a href="delete-comment.jsp" class="btn btn-danger">
            Delete Comment
        </a>

    </div>


    <!-- ================= KNOWLEDGE BASE ================= -->

    <div class="content-card">

        <h2>
            Knowledge Base
        </h2>

        <p class="page-subtitle">

            Create and manage helpful support articles.

        </p>


        <a href="articles" class="btn">
            View Knowledge Base
        </a>

        <a href="add-article.jsp" class="btn">
            Add Article
        </a>

        <a href="update-article.jsp" class="btn">
            Edit Article
        </a>

        <a href="delete-article.jsp" class="btn btn-danger">
            Delete Article
        </a>

    </div>


    <!-- ================= ACCOUNT ================= -->

    <div class="content-card">

        <h2>
            Account
        </h2>

        <p class="page-subtitle">

            You are logged in as
            <strong><%= loginUser.getUsername() %></strong>.

        </p>


        <a href="logout" class="btn btn-danger">
            Logout
        </a>

    </div>

</div>

</body>
</html>