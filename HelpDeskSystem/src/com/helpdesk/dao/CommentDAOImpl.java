package com.helpdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.model.Comment;
import com.helpdesk.util.DBConnection;

public class CommentDAOImpl implements CommentDAO {

    // Add Comment
    @Override
    public void addComment(Comment comment) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO comments "
                       + "(ticket_id, user_id, comment_text) "
                       + "VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, comment.getTicketId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getCommentText());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Comment Added Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // View Comments by Ticket
    @Override
    public List<Comment> viewCommentsByTicket(int ticketId) {

        List<Comment> comments = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM comments WHERE ticket_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ticketId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Comment comment = new Comment();

                comment.setCommentId(
                        rs.getInt("comment_id"));

                comment.setTicketId(
                        rs.getInt("ticket_id"));

                comment.setUserId(
                        rs.getInt("user_id"));

                comment.setCommentText(
                        rs.getString("comment_text"));

                comment.setCommentDate(
                        rs.getTimestamp("comment_date"));

                comments.add(comment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return comments;
    }


    // Get Comment by ID
    @Override
    public Comment getCommentById(int commentId) {

        Comment comment = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM comments WHERE comment_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, commentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                comment = new Comment();

                comment.setCommentId(
                        rs.getInt("comment_id"));

                comment.setTicketId(
                        rs.getInt("ticket_id"));

                comment.setUserId(
                        rs.getInt("user_id"));

                comment.setCommentText(
                        rs.getString("comment_text"));

                comment.setCommentDate(
                        rs.getTimestamp("comment_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return comment;
    }


    // Delete Comment
    @Override
    public void deleteComment(int commentId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM comments WHERE comment_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, commentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Comment Deleted Successfully");
            } else {
                System.out.println("Comment Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Get Total Comments
    @Override
    public int getTotalComments() {

        int count = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM comments";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}