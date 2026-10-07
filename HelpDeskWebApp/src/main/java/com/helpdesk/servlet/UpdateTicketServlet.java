package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.Login;
import com.helpdesk.service.TicketService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update-ticket")
public class UpdateTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TicketService ticketService;

    @Override
    public void init() throws ServletException {
        ticketService = new TicketService();
    }

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

        int ticketId =
                Integer.parseInt(request.getParameter("ticketId"));

        String status =
                request.getParameter("status");

        // Admin can update any ticket
        if ("Admin".equals(loginUser.getRole())) {

            ticketService.updateTicketStatus(ticketId, status);

        }

        // Agent can update only assigned tickets
        else if ("Agent".equals(loginUser.getRole())) {

            boolean assigned =
                    ticketService.isTicketAssignedToUser(
                            ticketId,
                            loginUser.getUserId());

            if (assigned) {

                ticketService.updateTicketStatus(
                        ticketId,
                        status);

            } else {

                response.sendRedirect(
                        request.getContextPath()
                        + "/tickets?error=notassigned");
                return;
            }
        }

        // User cannot update ticket status
        else {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login.jsp");
            return;
        }

        response.sendRedirect(
                request.getContextPath() + "/tickets");
    }
}