package com.userbanklist.service;

import com.userbanklist.DataBase;
import com.userbanklist.User;
import com.userbanklist.dao.DAO;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements DAO<User> {

    private DataBase dataBase = DataBase.getInstance();
    private static UserService instance;

    private UserService() {
    }

    public static UserService getUserService() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO user (userid, name, sureName) VALUES (?, ?, ?)";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSureName());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> list = new ArrayList<>();
        User user;
        String getData = "select * from user";
        try (Connection connection = dataBase.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getData);
            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String sureName = resultSet.getString("sureName");

                user = new User(userid, name, sureName);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getById(int id) {
        String getData = "select * from user where userid = ?";
        User user = null;
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getData)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String sureName = resultSet.getString("sureName");

                user = new User(userid, name, sureName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, sureName = ? where userid = ?";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSureName());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        String sql = "delete from user where userid = ?";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findRichestUser(){
        User user = null;
        String getData = "select user.userid, name, sureName, account from user, account" +
                "    where user.userid = account.userid" +
                "    and account = (select max(account) from account)";
        try (Connection connection = dataBase.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getData);

            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String sureName = resultSet.getString("sureName");

                user = new User(userid, name, sureName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
