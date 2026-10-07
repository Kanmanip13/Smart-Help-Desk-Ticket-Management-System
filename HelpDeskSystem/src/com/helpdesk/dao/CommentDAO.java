package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.model.Comment;

public interface CommentDAO {

    void addComment(Comment comment);

    List<Comment> viewCommentsByTicket(int ticketId);

    Comment getCommentById(int commentId);

    void deleteComment(int commentId);

    int getTotalComments();
}