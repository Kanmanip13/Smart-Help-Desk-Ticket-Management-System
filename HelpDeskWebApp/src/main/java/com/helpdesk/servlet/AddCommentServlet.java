package com.helpdesk.servlet;

import java.io.IOException;
import java.util.List;

import com.helpdesk.model.Comment;
import com.helpdesk.model.Login;
import com.helpdesk.model.Ticket;
import com.helpdesk.service.CommentService;
import com.helpdesk.service.TicketService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add-comment")
public class AddCommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CommentService commentService;
    private TicketService ticketService;

    @Override
    public void init() throws ServletException {
        commentService = new CommentService();
        ticketService = new TicketService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        // Check login session
        HttpSession session = request.getSession(false);

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

        String commentText =
                request.getParameter("commentText");

        int userId = loginUser.getUserId();

        boolean allowed = false;

        // Admin can comment on any ticket
        if ("Admin".equals(loginUser.getRole())) {

            allowed = true;
        }

        // Agent can comment only on assigned tickets
        else if ("Agent".equals(loginUser.getRole())) {

            allowed = ticketService.isTicketAssignedToUser(
                    ticketId,
                    userId);
        }

        // User can comment only on tickets created by them
        else if ("User".equals(loginUser.getRole())) {

            List<Ticket> tickets =
                    ticketService.viewTicketsCreatedByUser(userId);

            for (Ticket ticket : tickets) {

                if (ticket.getTicketId() == ticketId) {
                    allowed = true;
                    break;
                }
            }
        }

        // Reject unauthorized comment
        if (!allowed) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/tickets?error=notallowed");

            return;
        }

        // Create comment
        Comment comment = new Comment();

        comment.setTicketId(ticketId);
        comment.setUserId(userId);
        comment.setCommentText(commentText);

        commentService.addComment(comment);

        response.sendRedirect(
                request.getContextPath()
                + "/comments?ticketId=" + ticketId);
    }
}