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
import qlbhgg.models.Users;
import qlbhgg.models.WorkDay;

/**
 *
 * @author acer
 */
public class WorkDayDao {

    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findAll() throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListWorkDay;
    }

    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findByUsername(Users user) throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping WHERE id_user = '" + user.getId() + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListWorkDay;
    }

    @SuppressWarnings("empty-statement")
    public static int countWorkDay(String id, int month, int year) throws SQLException {
        int count = 0;
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT COUNT(work_day) as count_day FROM `timekeeping` WHERE id_user = '" + id + "' and month(work_day) = " + month + " and year(work_day) = " + year;
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_day");
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(WorkDayDao.countWorkDay("US00000002", 11, 2020));
    }
}
