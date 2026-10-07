package com.helpdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.model.KBArticle;
import com.helpdesk.util.DBConnection;

public class KBArticleDAOImpl implements KBArticleDAO {

    @Override
    public void createArticle(KBArticle article) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO kb_articles(title, content, category) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setString(3, article.getCategory());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Article Created Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KBArticle> viewArticles() {

        List<KBArticle> articles = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM kb_articles";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KBArticle article = new KBArticle();

                article.setArticleId(rs.getInt("article_id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCategory(rs.getString("category"));
                article.setCreatedDate(rs.getTimestamp("created_date"));

                articles.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    @Override
    public List<KBArticle> searchArticles(String keyword) {

        List<KBArticle> articles = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM kb_articles " +
                         "WHERE title LIKE ? OR content LIKE ? OR category LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            String searchKeyword = "%" + keyword + "%";

            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);
            ps.setString(3, searchKeyword);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                KBArticle article = new KBArticle();

                article.setArticleId(rs.getInt("article_id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCategory(rs.getString("category"));
                article.setCreatedDate(rs.getTimestamp("created_date"));

                articles.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    @Override
    public void deleteArticle(int articleId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM kb_articles WHERE article_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, articleId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Article Deleted Successfully");
            } else {
                System.out.println("Article Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateArticle(KBArticle article) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE kb_articles SET title = ?, content = ?, category = ? "
                       + "WHERE article_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setString(3, article.getCategory());
            ps.setInt(4, article.getArticleId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Article Updated Successfully");
            } else {
                System.out.println("Article Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}