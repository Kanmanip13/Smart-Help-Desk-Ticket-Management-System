package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.Comment;
import com.helpdesk.model.Login;
import com.helpdesk.service.CommentService;
import com.helpdesk.service.TicketService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete-comment")
public class DeleteCommentServlet extends HttpServlet {

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

        // Check login
        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("loginUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login.jsp");
            return;
        }

        Login loginUser =
                (Login) session.getAttribute("loginUser");

        int commentId =
                Integer.parseInt(request.getParameter("commentId"));

        // Get the comment first
        Comment comment =
                commentService.getCommentById(commentId);

        if (comment == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/tickets?error=commentnotfound");
            return;
        }

        int userId = loginUser.getUserId();

        boolean allowed = false;

        // Admin can delete any comment
        if ("Admin".equals(loginUser.getRole())) {

            allowed = true;
        }

        // Agent can delete comments on assigned tickets
        else if ("Agent".equals(loginUser.getRole())) {

            allowed = ticketService.isTicketAssignedToUser(
                    comment.getTicketId(),
                    userId);
        }

        // User can delete only their own comments
        else if ("User".equals(loginUser.getRole())) {

            if (comment.getUserId() == userId) {
                allowed = true;
            }
        }

        // Reject unauthorized deletion
        if (!allowed) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/tickets?error=notallowed");

            return;
        }

        // Delete comment
        commentService.deleteComment(commentId);

        response.sendRedirect(
                request.getContextPath() + "/tickets");
    }
}