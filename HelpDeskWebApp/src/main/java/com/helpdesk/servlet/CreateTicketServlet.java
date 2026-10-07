package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.Login;
import com.helpdesk.model.Ticket;
import com.helpdesk.service.TicketService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/create-ticket")
public class CreateTicketServlet extends HttpServlet {

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

        if (session == null ||
            session.getAttribute("loginUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");
            return;
        }

        Login loginUser =
                (Login) session.getAttribute("loginUser");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");

        Ticket ticket = new Ticket();

        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setPriority(priority);
        ticket.setStatus(status);

        // Store the logged-in user's ID as the ticket creator
        ticket.setCreatedBy(loginUser.getUserId());

        ticketService.createTicket(ticket);

        response.sendRedirect(
                request.getContextPath() + "/tickets");
    }
}