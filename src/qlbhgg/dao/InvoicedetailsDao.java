/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.Connection;
import qlbhgg.models.Invoicedetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class InvoicedetailsDao {

    @SuppressWarnings("empty-statement")
    public static ArrayList<Invoicedetails> findInvoicedetailsByIdBill(String id) throws SQLException {
        ArrayList<Invoicedetails> ListInvoicedetails = new ArrayList<>();

        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from invoicedetails where code_bill = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Invoicedetails iv = Invoicedetails.getFromResultSet(resulSet);
                ListInvoicedetails.add(iv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListInvoicedetails;
    }

    public static void main(String[] args) throws SQLException {
    }
}
