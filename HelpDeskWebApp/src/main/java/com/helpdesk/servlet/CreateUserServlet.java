package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.User;
import com.helpdesk.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

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
    	System.out.println("CreateUserServlet is called");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setRole(role);

        userService.createUser(user);

        response.sendRedirect(request.getContextPath() + "/users");
    }
}