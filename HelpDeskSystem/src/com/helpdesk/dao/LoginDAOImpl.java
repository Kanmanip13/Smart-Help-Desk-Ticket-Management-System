package com.helpdesk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.helpdesk.model.Login;
import com.helpdesk.util.DBConnection;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public Login login(String username, String password) {

        Login login = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM login_users " +
                         "WHERE username = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                login = new Login();

                login.setLoginId(rs.getInt("login_id"));
                login.setUserId(rs.getInt("user_id"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                login.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return login;
    }
}