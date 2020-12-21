/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.controller.LoginController;

import java.sql.SQLException;
import qlbhgg.dao.UsersDao;
import qlbhgg.models.Users;
import qlbhgg.views.login.LoginForm;

/**
 *
 * @author duycoding
 */
public class LoginController {
    private LoginForm view;

    public LoginController(LoginForm view) {
        this.view = view;
    }
    
    public LoginForm getView() {
        return view;
    }

    public void setView(LoginForm view) {
        this.view = view;
    }
    public Users login() throws SQLException{
        Users user = checkLogin();
        if(user != null) {
            return user;
        }
        return null;
    }
    private Users checkLogin() throws SQLException {
        Users userView = view.getUser();
        UsersDao ud = new UsersDao();
        Users userModel = ud.findUserLogin(userView.getUsername(), userView.getPassword());
        if(userModel == null) {
            return null;
        } else {
            return userModel;
        }
    }
}
