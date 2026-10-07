package com.helpdesk.dao;

import com.helpdesk.model.Login;

public interface LoginDAO {

    Login login(String username, String password);

}