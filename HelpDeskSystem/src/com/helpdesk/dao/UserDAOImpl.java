package com.helpdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helpdesk.model.User;
import com.helpdesk.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    // ============================
    // CREATE USER
    // ============================

    @Override
    public void createUser(User user) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO users (name, email, role) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getRole());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "User Created Successfully");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // ============================
    // VIEW ALL USERS
    // ============================

    @Override
    public List<User> viewUsers() {

        List<User> users = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setName(
                        rs.getString("name"));

                user.setEmail(
                        rs.getString("email"));

                user.setRole(
                        rs.getString("role"));

                users.add(user);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return users;
    }


    // ============================
    // VIEW ONLY AGENTS
    // ============================

    @Override
    public List<User> viewAgents() {

        List<User> agents = new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT user_id, name, email, role " +
                    "FROM users " +
                    "WHERE TRIM(LOWER(role)) = 'agent'";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setName(
                        rs.getString("name"));

                user.setEmail(
                        rs.getString("email"));

                user.setRole(
                        rs.getString("role"));

                agents.add(user);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return agents;
    }


    // ============================
    // GET USER BY ID
    // ============================

    @Override
    public User getUserById(int userId) {

        User user = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users " +
                    "WHERE user_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setName(
                        rs.getString("name"));

                user.setEmail(
                        rs.getString("email"));

                user.setRole(
                        rs.getString("role"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return user;
    }


    // ============================
    // UPDATE USER ROLE
    // ============================

    @Override
    public void updateUserRole(
            int userId,
            String role) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE users SET role = ? " +
                    "WHERE user_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, role);
            ps.setInt(2, userId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User Role Updated Successfully");

            } else {

                System.out.println(
                        "User Not Found");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // ============================
    // DELETE USER
    // ============================

    @Override
    public void deleteUser(int userId) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM users " +
                    "WHERE user_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, userId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User Deleted Successfully");

            } else {

                System.out.println(
                        "User Not Found");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // ============================
    // TOTAL USERS
    // ============================

    @Override
    public int getTotalUsers() {

        int count = 0;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) FROM users";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                count = rs.getInt(1);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return count;
    }
}