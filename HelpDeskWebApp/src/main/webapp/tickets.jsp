<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.helpdesk.model.Ticket" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Smart Help Desk - Tickets</title>

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
        Ticket Management
    </h1>

    <p class="page-subtitle">
        View and manage your support tickets.
    </p>


    <!-- ================= ERROR MESSAGES ================= -->

    <%
        String error = request.getParameter("error");

        if ("notassigned".equals(error)) {
    %>

        <div class="content-card">
            <p class="error">
                You can update only tickets assigned to you.
            </p>
        </div>

    <%
        } else if ("notallowed".equals(error)) {
    %>

        <div class="content-card">
            <p class="error">
                You are not allowed to perform this action.
            </p>
        </div>

    <%
        } else if ("commentnotfound".equals(error)) {
    %>

        <div class="content-card">
            <p class="error">
                Comment not found.
            </p>
        </div>

    <%
        }
    %>


    <!-- ================= TICKETS TABLE ================= -->

    <div class="content-card">

        <h2>Tickets</h2>

        <%
            List<Ticket> tickets =
                (List<Ticket>) request.getAttribute("tickets");

            Map<Integer, String> userNames =
                (Map<Integer, String>)
                request.getAttribute("userNames");
        %>

        <%
            if (tickets != null && !tickets.isEmpty()) {
        %>

        <table>

            <tr>

                <th>ID</th>

                <th>Title</th>

                <th>Description</th>

                <th>Priority</th>

                <th>Status</th>

                <th>Created By</th>

                <th>Assigned To</th>

                <th>Action</th>

            </tr>


            <%
                for (Ticket ticket : tickets) {

                    String creatorName =
                        "Not Available";

                    String assignedName =
                        "Not Assigned";


                    if (ticket.getCreatedBy() > 0 &&
                        userNames != null &&
                        userNames.containsKey(
                            ticket.getCreatedBy())) {

                        creatorName =
                            userNames.get(
                                ticket.getCreatedBy());
                    }


                    if (ticket.getAssignedTo() > 0 &&
                        userNames != null &&
                        userNames.containsKey(
                            ticket.getAssignedTo())) {

                        assignedName =
                            userNames.get(
                                ticket.getAssignedTo());
                    }


                    String statusClass =
                        "status-open";


                    if ("In Progress".equalsIgnoreCase(
                            ticket.getStatus())) {

                        statusClass =
                            "status-progress";

                    } else if ("Resolved".equalsIgnoreCase(
                            ticket.getStatus())) {

                        statusClass =
                            "status-resolved";
                    }
            %>

            <tr>

                <td>
                    <%= ticket.getTicketId() %>
                </td>

                <td>
                    <strong>
                        <%= ticket.getTitle() %>
                    </strong>
                </td>

                <td>
                    <%= ticket.getDescription() %>
                </td>

                <td>
                    <%= ticket.getPriority() %>
                </td>

                <td>

                    <span class="status <%= statusClass %>">
                        <%= ticket.getStatus() %>
                    </span>

                </td>

                <td>
                    <%= creatorName %>
                </td>

                <td>
                    <%= assignedName %>
                </td>

                <td>

                    <a href="comments?ticketId=<%= ticket.getTicketId() %>"
                       class="btn">

                        Comments

                    </a>

                </td>

            </tr>

            <%
                }
            %>

        </table>

        <%
            } else {
        %>

            <p>
                No tickets found.
            </p>

        <%
            }
        %>

    </div>


    <!-- ================= ACTIONS ================= -->

    <div class="content-card">

        <h2>Quick Actions</h2>

        <br>

        <a href="create-ticket.jsp"
           class="btn">

            Create New Ticket

        </a>

        <a href="add-comment.jsp"
           class="btn">

            Add Comment

        </a>

    </div>

</div>

</body>
</html>