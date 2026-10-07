package com.helpdesk.servlet;

import java.io.IOException;
import java.util.List;

import com.helpdesk.model.User;
import com.helpdesk.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userService.viewUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher("users.jsp")
               .forward(request, response);
    }
}