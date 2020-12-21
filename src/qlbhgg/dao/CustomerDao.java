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
import java.util.ArrayList;
import qlbhgg.models.Customers;

/**
 *
 * @author acer
 */
@SuppressWarnings("empty-statement")
public class CustomerDao {

    @SuppressWarnings("empty-statement")
    public static Customers findCustomerById(String id) throws SQLException {
        Customers customer = new Customers();
        Connection connection = Database.getInstance().getConnection();
        try {
            java.sql.Statement statement = connection.createStatement();
            statement = connection.createStatement();
            String sql = "select * from customer where customer_code = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                customer = Customers.getFromResultSet(resulSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @SuppressWarnings("empty-statement")
    public static ArrayList<Customers> findAllCustomer() throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();

        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static ArrayList<Customers> searchCustomer(String str) throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();

        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from customer where customer_code like '%" + str + "%' or customer_name like '%" + str + "%' or trading_name like '%" + str + "%' or address like '%" + str + "%' or email like '%" + str + "%' or phone_number like '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Customers> lc = CustomerDao.searchCustomer("build bộ pc");
        for (Customers customers : lc) {
            System.out.println(customers.toString());
        }
    }
}
