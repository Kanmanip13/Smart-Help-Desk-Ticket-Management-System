package com.helpdesk.model;

import java.sql.Timestamp;

public class KBArticle {

    private int articleId;
    private String title;
    private String content;
    private String category;
    private Timestamp createdDate;

    public KBArticle() {
    }

    public KBArticle(int articleId, String title, String content,
                     String category, Timestamp createdDate) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdDate = createdDate;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}