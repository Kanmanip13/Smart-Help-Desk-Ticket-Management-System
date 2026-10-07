package com.helpdesk.service;

import com.helpdesk.dao.LoginDAO;
import com.helpdesk.dao.LoginDAOImpl;
import com.helpdesk.model.Login;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        loginDAO = new LoginDAOImpl();
    }

    public Login authenticate(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty");
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password cannot be empty");
            return null;
        }

        return loginDAO.login(username, password);
    }
}