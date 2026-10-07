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

@WebServlet("/delete-ticket")
public class DeleteTicketServlet extends HttpServlet {

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

        // Only Admin can delete tickets
        if (!"Admin".equals(loginUser.getRole())) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");
            return;
        }

        int ticketId =
                Integer.parseInt(request.getParameter("ticketId"));

        ticketService.deleteTicket(ticketId);

        response.sendRedirect(
                request.getContextPath() + "/tickets");
    }
}