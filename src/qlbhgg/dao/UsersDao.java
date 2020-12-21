/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UsersDao {
    
    

    /**
     *
     * @return @throws SQLException
     */
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findAll() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from `users`";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public static Users findUserLogin(String username, String password) throws SQLException {
        Users user = new Users();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from users where user_name = '" + username + "' AND password = '" + password +"'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user = user.getFromResultSet(resulSet);
                return user;
            }
            resulSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Users getUser(String username) throws SQLException {
        Users user = new Users();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from users where user_name = '" + username + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user = user.getFromResultSet(resulSet);
                return user;
            }
            resulSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findStaff() throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from users where role = 'Nhân viên'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countUserBy(String str) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods JOIN typeofgoods ON goods.type_code = typeofgoods.type_code WHERE typeofgoods.type_name = '" + str + "';";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countStaff() throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(user_name) as count_staff from users WHERE role = 'Nhân viên'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_staff");
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public static void updateStatus(Users us) {
        PreparedStatement statement = null;
        Connection connection = Database.getInstance().getConnection();
        try {
            String sql = "update users set status = ? where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getStatus());
            statement.setString(2, us.getUsername());

            statement.execute();
            System.out.println("Updated status!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static Users findStaffByUsername(String username) throws SQLException {
        Users user = new Users();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from users where role = 'Nhân viên' and user_name = '" + username + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user.getFromResultSet(resulSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    
    public static void deleteStaff(Users us) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM `users` WHERE `users`.`user_name` = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getUsername());

            statement.execute();
            System.out.println("Deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> searchStaff(String str) throws SQLException {
        ArrayList<Users> users = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and (id_user LIKE '%" + str + "%' or user_name LIKE '%" + str + "%' or full_name LIKE '%" + str + "%' or gender LIKE '%" + str + "%' or birthday LIKE '%" + str + "%' or start_date LIKE '%" + str + "%' or address LIKE '%" + str + "%' or phone_number LIKE '%" + str + "%' or email LIKE '%" + str + "%' or basic_salary LIKE '%" + str + "%' or allowance LIKE '%" + str + "%' or status LIKE '%" + str + "%')";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countStaffSearch(String str) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT COUNT(user_name) as count_staff from users WHERE role = 'Nhân viên' and (id_user LIKE '%" + str + "%' or user_name LIKE '%" + str + "%' or full_name LIKE '%" + str + "%' or gender LIKE '%" + str + "%' or birthday LIKE '%" + str + "%' or start_date LIKE '%" + str + "%' or address LIKE '%" + str + "%' or phone_number LIKE '%" + str + "%' or email LIKE '%" + str + "%' or basic_salary LIKE '%" + str + "%' or allowance LIKE '%" + str + "%' or status LIKE '%" + str + "%')";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_staff");
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return count;
    }
    
    public static void insertStaff(Users us) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO `users` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getId());
            statement.setString(2, us.getUsername());
            statement.setString(3, us.getPassword());
            statement.setString(4, us.getRole());
            statement.setString(5, us.getFullname());
            statement.setString(6, us.getGender());
            
            java.sql.Date birthday =  new java.sql.Date(us.getBirthday().getTime());
            java.sql.Date startdate = new java.sql.Date(us.getStartdate().getTime());
            
            statement.setDate(7, birthday);
            statement.setDate(8, startdate);
            statement.setString(9, us.getAddress());
            statement.setString(10, us.getPhonenumber());
            statement.setString(11, us.getEmail());
            statement.setFloat(12, us.getBasicsalary());
            statement.setFloat(13, us.getAllowance());
            statement.setString(14, us.getImage_user());
            statement.setString(15, us.getStatus());

            statement.execute();
            System.out.println("Insert successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> findStaffBy(String id, String username, String phonenumber, String email) throws SQLException {
        ArrayList<Users> users = new ArrayList<Users>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and (id_user = '" + id + "' or user_name = '" + username + "' or  phone_number = '" + phonenumber + "' or email = '" + email + "')";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Users> checkEmail(String email) throws SQLException {
        ArrayList<Users> users = new ArrayList<Users>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and email = '" + email + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Users ur = Users.getFromResultSet(resulSet);
                users.add(ur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public static void updateStaff(Users us) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            
            String sql = "update users set full_name = ?, gender = ?, birthday = ?, start_date = ?, address = ?, basic_salary = ?, allowance = ?, image_user = ? where user_name = ?;";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getFullname());
            statement.setString(2, us.getGender());
            
            java.sql.Date birthday =  new java.sql.Date(us.getBirthday().getTime());
            java.sql.Date startdate = new java.sql.Date(us.getStartdate().getTime());
            
            statement.setDate(3, birthday);
            statement.setDate(4, startdate);
            statement.setString(5, us.getAddress());
            statement.setFloat(6, us.getBasicsalary());
            statement.setFloat(7, us.getAllowance());
            statement.setString(8, us.getImage_user());
            statement.setString(9, us.getUsername());

            statement.execute();
            System.out.println("Insert successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("empty-statement")
    public static Users findStaffById(String id) throws SQLException {
        Users user = new Users();
        Connection connection = Database.getInstance().getConnection();
        Statement statement = null;
        try {      
            statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE role = 'Nhân viên' and id_user = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                user = Users.getFromResultSet(resulSet);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static void chancePassword(String username, String password) {
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update users set password = ? where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, password);
            statement.setString(2, username);
            
            statement.execute();
            System.out.println("Chance password successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws SQLException {
        chancePassword("anhtaideptrai", "anhtai3d2y");
    }
}

