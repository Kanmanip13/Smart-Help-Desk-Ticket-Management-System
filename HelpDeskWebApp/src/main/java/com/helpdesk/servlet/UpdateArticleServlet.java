package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.KBArticle;
import com.helpdesk.service.KBArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-article")
public class UpdateArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private KBArticleService articleService;

    @Override
    public void init() throws ServletException {
        articleService = new KBArticleService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(
                request.getParameter("articleId"));

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String category = request.getParameter("category");

        KBArticle article = new KBArticle();

        article.setArticleId(articleId);
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);

        articleService.updateArticle(article);

        response.sendRedirect(
                request.getContextPath() + "/articles");
    }
}