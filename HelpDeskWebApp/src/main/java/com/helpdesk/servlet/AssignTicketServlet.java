package com.helpdesk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.model.Login;
import com.helpdesk.model.User;
import com.helpdesk.service.TicketService;
import com.helpdesk.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/assign-ticket")
public class AssignTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TicketService ticketService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ticketService = new TicketService();
        userService = new UserService();
    }

    // Open Assign Ticket page
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check login
        if (session == null ||
            session.getAttribute("loginUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");

            return;
        }

        Login loginUser =
                (Login) session.getAttribute("loginUser");

        // Only Admin can assign tickets
        if (!"Admin".equalsIgnoreCase(loginUser.getRole())) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");

            return;
        }

        // Get all users
        List<User> users = userService.viewUsers();

        // Create list for Agents only
        List<User> agents = new ArrayList<>();

        for (User user : users) {

            if (user.getRole() != null &&
                user.getRole().trim().equalsIgnoreCase("Agent")) {

                agents.add(user);
            }
        }

        // Debug
        System.out.println("========== ASSIGN TICKET ==========");
        System.out.println("Total users: " + users.size());
        System.out.println("Total agents: " + agents.size());

        for (User agent : agents) {

            System.out.println(
                    "Agent ID: " + agent.getUserId()
                    + " | Name: " + agent.getName()
                    + " | Role: " + agent.getRole()
            );
        }

        System.out.println("===================================");

        // Send ONLY agents to JSP
        request.setAttribute("agents", agents);

        request.getRequestDispatcher(
                "/assign-ticket.jsp")
               .forward(request, response);
    }


    // Assign Ticket
    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check login
        if (session == null ||
            session.getAttribute("loginUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");

            return;
        }

        Login loginUser =
                (Login) session.getAttribute("loginUser");

        // Only Admin can assign
        if (!"Admin".equalsIgnoreCase(loginUser.getRole())) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");

            return;
        }

        String ticketIdParameter =
                request.getParameter("ticketId");

        String assignedToParameter =
                request.getParameter("assignedTo");

        if (ticketIdParameter == null ||
            assignedToParameter == null ||
            ticketIdParameter.trim().isEmpty() ||
            assignedToParameter.trim().isEmpty()) {

            response.sendRedirect(
                    request.getContextPath() + "/assign-ticket");

            return;
        }

        try {

            int ticketId =
                    Integer.parseInt(ticketIdParameter);

            int assignedTo =
                    Integer.parseInt(assignedToParameter);

            ticketService.assignTicket(
                    ticketId,
                    assignedTo);

            System.out.println(
                    "Ticket " + ticketId
                    + " assigned to Agent " + assignedTo);

            response.sendRedirect(
                    request.getContextPath() + "/tickets");

        } catch (NumberFormatException e) {

            e.printStackTrace();

            response.sendRedirect(
                    request.getContextPath() + "/assign-ticket");
        }
    }
}