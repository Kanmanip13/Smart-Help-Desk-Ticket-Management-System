package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.service.KBArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-article")
public class DeleteArticleServlet extends HttpServlet {

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

        int articleId =
                Integer.parseInt(request.getParameter("articleId"));

        articleService.deleteArticle(articleId);

        response.sendRedirect(
                request.getContextPath() + "/articles");
    }
}