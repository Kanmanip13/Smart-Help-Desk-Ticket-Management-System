package com.helpdesk.servlet;

import java.io.IOException;

import com.helpdesk.model.Login;
import com.helpdesk.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = loginService.authenticate(username, password);

        if (login != null) {

            HttpSession session = request.getSession();

            session.setAttribute("loginUser", login);
            session.setAttribute("userId", login.getUserId());
            session.setAttribute("username", login.getUsername());
            session.setAttribute("role", login.getRole());

            if ("Admin".equals(login.getRole())) {

                response.sendRedirect(
                        request.getContextPath()
                        + "/admin-dashboard.jsp");

            } else if ("Agent".equals(login.getRole())) {

                response.sendRedirect(
                        request.getContextPath()
                        + "/agent-dashboard");

            } else if ("User".equals(login.getRole())) {

                response.sendRedirect(
                        request.getContextPath()
                        + "/user-dashboard");

            } else {

                response.sendRedirect(
                        request.getContextPath()
                        + "/login.jsp?error=role");
            }

        } else {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login.jsp?error=invalid");
        }
    }
}