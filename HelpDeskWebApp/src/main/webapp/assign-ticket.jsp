<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.helpdesk.model.User" %>

<%
    List<User> agents =
        (List<User>) request.getAttribute("agents");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Assign Ticket</title>

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
        Assign Ticket
    </h1>

    <p class="page-subtitle">
        Assign a support ticket to an available agent.
    </p>


    <!-- ================= FORM ================= -->

    <div class="form-card">

        <form action="assign-ticket" method="post">


            <!-- TICKET ID -->

            <label for="ticketId">
                Ticket ID
            </label>

            <input
                type="number"
                id="ticketId"
                name="ticketId"
                placeholder="Enter Ticket ID"
                required>


            <!-- AGENT -->

            <label for="assignedTo">
                Select Agent
            </label>

            <select
                id="assignedTo"
                name="assignedTo"
                required>

                <option value="">
                    Select an Agent
                </option>


                <%
                    if (agents != null && !agents.isEmpty()) {

                        for (User agent : agents) {
                %>

                <option value="<%= agent.getUserId() %>">
                    <%= agent.getName() %>
                </option>

                <%
                        }

                    } else {
                %>

                <option value="">
                    No agents available
                </option>

                <%
                    }
                %>

            </select>


            <br>
            <br>


            <!-- BUTTON -->

            <button
                type="submit"
                class="btn btn-success">

                Assign Ticket

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
            Assignment Information
        </h2>

        <p class="page-subtitle">
            Only users with the Agent role are displayed.
        </p>

        <p>
            After assigning a ticket, the selected agent can
            view the ticket from the My Tickets page and
            update its status.
        </p>

    </div>

</div>


</body>

</html>