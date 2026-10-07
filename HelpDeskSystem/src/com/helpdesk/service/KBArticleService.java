package com.helpdesk.service;

import java.util.List;

import com.helpdesk.dao.KBArticleDAO;
import com.helpdesk.dao.KBArticleDAOImpl;
import com.helpdesk.model.KBArticle;

public class KBArticleService {

    private KBArticleDAO articleDAO;

    public KBArticleService() {
        articleDAO = new KBArticleDAOImpl();
    }

    // CREATE
    public void createArticle(KBArticle article) {

        if (article == null) {
            System.out.println("Article cannot be null");
            return;
        }

        if (article.getTitle() == null ||
            article.getTitle().trim().isEmpty()) {

            System.out.println("Article title cannot be empty");
            return;
        }

        if (article.getContent() == null ||
            article.getContent().trim().isEmpty()) {

            System.out.println("Article content cannot be empty");
            return;
        }

        if (article.getCategory() == null ||
            article.getCategory().trim().isEmpty()) {

            System.out.println("Article category cannot be empty");
            return;
        }

        articleDAO.createArticle(article);
    }

    // READ
    public List<KBArticle> viewArticles() {
        return articleDAO.viewArticles();
    }

    // SEARCH
    public List<KBArticle> searchArticles(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return viewArticles();
        }

        return articleDAO.searchArticles(keyword);
    }

    // DELETE
    public void deleteArticle(int articleId) {

        if (articleId <= 0) {
            System.out.println("Invalid article ID");
            return;
        }

        articleDAO.deleteArticle(articleId);
    }public void updateArticle(KBArticle article) {

        if (article == null) {
            System.out.println("Article cannot be null");
            return;
        }

        if (article.getArticleId() <= 0) {
            System.out.println("Invalid article ID");
            return;
        }

        if (article.getTitle() == null ||
            article.getTitle().trim().isEmpty()) {
            System.out.println("Article title cannot be empty");
            return;
        }

        if (article.getContent() == null ||
            article.getContent().trim().isEmpty()) {
            System.out.println("Article content cannot be empty");
            return;
        }

        if (article.getCategory() == null ||
            article.getCategory().trim().isEmpty()) {
            System.out.println("Article category cannot be empty");
            return;
        }

        articleDAO.updateArticle(article);
    }
}