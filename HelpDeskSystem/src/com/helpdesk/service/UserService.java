package com.helpdesk.service;

import java.util.List;

import com.helpdesk.dao.UserDAO;
import com.helpdesk.dao.UserDAOImpl;
import com.helpdesk.model.User;

public class UserService {

    private UserDAO userDAO;


    // ============================
    // CONSTRUCTOR
    // ============================

    public UserService() {

        userDAO = new UserDAOImpl();
    }


    // ============================
    // CREATE USER
    // ============================

    public void createUser(User user) {

        if (user == null) {

            System.out.println(
                    "User cannot be null");

            return;
        }

        if (user.getName() == null ||
            user.getName().trim().isEmpty()) {

            System.out.println(
                    "User name cannot be empty");

            return;
        }

        if (user.getEmail() == null ||
            user.getEmail().trim().isEmpty()) {

            System.out.println(
                    "Email cannot be empty");

            return;
        }

        userDAO.createUser(user);
    }


    // ============================
    // VIEW ALL USERS
    // ============================

    public List<User> viewUsers() {

        return userDAO.viewUsers();
    }


    // ============================
    // VIEW ONLY AGENTS
    // ============================

    public List<User> viewAgents() {

        return userDAO.viewAgents();
    }


    // ============================
    // UPDATE ROLE
    // ============================

    public void updateUserRole(
            int userId,
            String role) {

        if (role == null ||
            role.trim().isEmpty()) {

            System.out.println(
                    "Role cannot be empty");

            return;
        }

        userDAO.updateUserRole(
                userId,
                role);
    }


    // ============================
    // DELETE USER
    // ============================

    public void deleteUser(int userId) {

        if (userId <= 0) {

            System.out.println(
                    "Invalid user ID");

            return;
        }

        userDAO.deleteUser(userId);
    }


    // ============================
    // TOTAL USERS
    // ============================

    public int getTotalUsers() {

        return userDAO.getTotalUsers();
    }


    // ============================
    // GET USER BY ID
    // ============================

    public User getUserById(int userId) {

        if (userId <= 0) {

            return null;
        }

        return userDAO.getUserById(userId);
    }
}