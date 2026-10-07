package com.helpdesk.dao;

import java.util.List;

import com.helpdesk.model.User;

public interface UserDAO {

    // CREATE
    void createUser(User user);

    // READ ALL USERS
    List<User> viewUsers();

    // READ ONLY AGENTS
    List<User> viewAgents();

    // GET USER BY ID
    User getUserById(int userId);

    // UPDATE ROLE
    void updateUserRole(int userId, String role);

    // DELETE USER
    void deleteUser(int userId);

    // TOTAL USERS
    int getTotalUsers();
}