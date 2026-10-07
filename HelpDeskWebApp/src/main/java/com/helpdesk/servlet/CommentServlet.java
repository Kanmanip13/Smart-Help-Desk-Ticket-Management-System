package com.helpdesk.servlet;

import java.io.IOException;
import java.util.List;

import com.helpdesk.model.Comment;
import com.helpdesk.service.CommentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comments")
public class CommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        commentService = new CommentService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int ticketId = Integer.parseInt(
                request.getParameter("ticketId"));

        List<Comment> comments =
                commentService.viewCommentsByTicket(ticketId);

        request.setAttribute("comments", comments);
        request.setAttribute("ticketId", ticketId);

        request.getRequestDispatcher("comments.jsp")
               .forward(request, response);
    }
}