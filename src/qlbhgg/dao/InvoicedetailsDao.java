/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Invoicedetails;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlbhgg.models.Users;

/**
 *
 * @author acer
 */
public class InvoicedetailsDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Invoicedetails> findInvoicedetailsByIdBill(String id) throws SQLException {
        ArrayList<Invoicedetails> ListInvoicedetails = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from invoicedetails where code_bill = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Invoicedetails iv = Invoicedetails.getFromResultSet(resulSet);
                ListInvoicedetails.add(iv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Invoicedetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Invoicedetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListInvoicedetails;
    }
    
    public static void addInvoicedetails(Invoicedetails i) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "INSERT INTO `invoicedetails`(`code_bill`, `item_code`, `price`, `amount`, `discount`) VALUES (?,?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, i.getCodebill());
            statement.setString(2, i.getItemcode());
            statement.setFloat(3, i.getPrice());
            statement.setInt(4, i.getAmount());
            statement.setInt(5, i.getDiscount());

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
    public static void main(String[] args) throws SQLException {
    }
}
