/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.Connection;
import qlbhgg.models.Suppliers;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class SupplierDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Suppliers> findAllSupplier() throws SQLException {
        ArrayList<Suppliers> ListSupplier = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Suppliers s = Suppliers.getFromResultSet(resulSet);
                ListSupplier.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListSupplier;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countSupplier() throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select count(company_code) as count_supplier from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_supplier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    public static void main(String[] args) throws SQLException {
        ArrayList<Suppliers> ListSupplier = SupplierDao.findAllSupplier();
        ListSupplier.forEach(suppliers -> {
            System.out.println(suppliers.toString());
        });
        int count = SupplierDao.countSupplier();
        System.out.println(count);
    }
}
