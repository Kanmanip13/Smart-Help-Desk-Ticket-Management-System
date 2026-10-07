package com.helpdesk.service;

import java.util.List;

import com.helpdesk.dao.CommentDAO;
import com.helpdesk.dao.CommentDAOImpl;
import com.helpdesk.model.Comment;


public class CommentService {

    private CommentDAO commentDAO;

    public CommentService() {
        commentDAO = new CommentDAOImpl();
    }

    // CREATE
    public void addComment(Comment comment) {

        if (comment == null) {
            System.out.println("Comment cannot be null");
            return;
        }

        if (comment.getCommentText() == null ||
            comment.getCommentText().trim().isEmpty()) {

            System.out.println("Comment cannot be empty");
            return;
        }

        if (comment.getTicketId() <= 0) {
            System.out.println("Invalid ticket ID");
            return;
        }

        if (comment.getUserId() <= 0) {
            System.out.println("Invalid user ID");
            return;
        }

        commentDAO.addComment(comment);
    }

    // READ
    public List<Comment> viewCommentsByTicket(int ticketId) {

        if (ticketId <= 0) {
            System.out.println("Invalid ticket ID");
            return new java.util.ArrayList<>();
        }

        return commentDAO.viewCommentsByTicket(ticketId);
    }

    // DELETE
    public void deleteComment(int commentId) {

        if (commentId <= 0) {
            System.out.println("Invalid comment ID");
            return;
        }

        commentDAO.deleteComment(commentId);
    }
    public int getTotalComments() {
        return commentDAO.getTotalComments();
    }
    public Comment getCommentById(int commentId) {

        if (commentId <= 0) {
            return null;
        }

        return commentDAO.getCommentById(commentId);
    }
}