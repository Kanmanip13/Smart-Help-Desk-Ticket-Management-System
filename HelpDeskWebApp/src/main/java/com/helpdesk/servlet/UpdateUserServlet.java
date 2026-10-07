package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(
                request.getParameter("userId"));

        String role = request.getParameter("role");

        userService.updateUserRole(userId, role);

        response.sendRedirect(request.getContextPath() + "/users");
    }
}