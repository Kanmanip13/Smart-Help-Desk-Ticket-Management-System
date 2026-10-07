package com.helpdesk.servlet;

import java.io.IOException;
import java.util.List;

import com.helpdesk.model.KBArticle;
import com.helpdesk.service.KBArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articles")
public class KBArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private KBArticleService articleService;

    @Override
    public void init() throws ServletException {
        articleService = new KBArticleService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<KBArticle> articles;

        if (keyword == null || keyword.trim().isEmpty()) {
            articles = articleService.viewArticles();
        } else {
            articles = articleService.searchArticles(keyword);
        }

        request.setAttribute("articles", articles);

        request.getRequestDispatcher("articles.jsp")
               .forward(request, response);
    }
}