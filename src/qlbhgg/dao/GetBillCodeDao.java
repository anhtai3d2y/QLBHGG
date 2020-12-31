/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.models.Goods;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class GetBillCodeDao {
    public static String getBillCode() throws SQLException {
        String bc = "B";
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM next_code";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                int code = resulSet.getInt("code_bill");
                String strCode = String.valueOf(code);
                for(int i = 0;i<9 - strCode.length();i++){
                    bc += "0";
                }
                bc += strCode;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Goods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return bc;
    }
    public static void updateCodeBill() {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "UPDATE `next_code` SET `code_bill`= code_bill + 1";
            statement = connection.prepareCall(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
