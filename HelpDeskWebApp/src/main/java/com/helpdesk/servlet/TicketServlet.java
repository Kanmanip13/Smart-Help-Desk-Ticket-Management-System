package com.helpdesk.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helpdesk.model.Login;
import com.helpdesk.model.Ticket;
import com.helpdesk.model.User;
import com.helpdesk.service.TicketService;
import com.helpdesk.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TicketService ticketService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ticketService = new TicketService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("loginUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");
            return;
        }

        Login loginUser =
                (Login) session.getAttribute("loginUser");

        List<Ticket> tickets;

        if ("Admin".equals(loginUser.getRole())) {

            tickets = ticketService.viewTickets();

        } else if ("Agent".equals(loginUser.getRole())) {

            tickets = ticketService.viewTicketsByUser(
                    loginUser.getUserId());

        } else if ("User".equals(loginUser.getRole())) {

            tickets = ticketService.viewTicketsCreatedByUser(
                    loginUser.getUserId());

        } else {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");
            return;
        }

        /*
         * Store user names in maps.
         *
         * Key   = User ID
         * Value = User Name
         */
        Map<Integer, String> userNames = new HashMap<>();

        for (Ticket ticket : tickets) {

            int createdBy = ticket.getCreatedBy();
            int assignedTo = ticket.getAssignedTo();

            // Get creator name
            if (createdBy > 0 &&
                !userNames.containsKey(createdBy)) {

                User user = userService.getUserById(createdBy);

                if (user != null) {
                    userNames.put(
                            createdBy,
                            user.getName());
                }
            }

            // Get assigned agent name
            if (assignedTo > 0 &&
                !userNames.containsKey(assignedTo)) {

                User user = userService.getUserById(assignedTo);

                if (user != null) {
                    userNames.put(
                            assignedTo,
                            user.getName());
                }
            }
        }

        request.setAttribute("tickets", tickets);
        request.setAttribute("userNames", userNames);

        request.getRequestDispatcher("/tickets.jsp")
               .forward(request, response);
    }
}