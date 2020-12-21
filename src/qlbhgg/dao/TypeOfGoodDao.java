/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author acer
 */
public class TypeOfGoodDao {

    public static void setComboboxType(JComboBox cbb) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT type_name FROM typeofgoods";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                cbb.addItem(resulSet.getNString("type_name"));
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
