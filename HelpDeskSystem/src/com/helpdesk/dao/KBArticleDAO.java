package com.helpdesk.dao;

import java.util.List;
import com.helpdesk.model.KBArticle;

public interface KBArticleDAO {

    void createArticle(KBArticle article);

    List<KBArticle> viewArticles();

    List<KBArticle> searchArticles(String keyword);

    void updateArticle(KBArticle article);

    void deleteArticle(int articleId);
}