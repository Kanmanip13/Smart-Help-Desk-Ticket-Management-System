package com.helpdesk.model;

import java.sql.Timestamp;

public class Comment {

    private int commentId;
    private int ticketId;
    private int userId;
    private String commentText;
    private Timestamp commentDate;

    public Comment() {
    }

    public Comment(int commentId, int ticketId, int userId,
                   String commentText, Timestamp commentDate) {
        this.commentId = commentId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }
}