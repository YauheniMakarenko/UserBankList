package com.userbanklist.service;

import com.userbanklist.Account;
import com.userbanklist.DataBase;
import com.userbanklist.dao.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements DAO<Account> {

    private DataBase dataBase = DataBase.getInstance();

    private static AccountService instance;

    private AccountService() {
    }

    public static AccountService getAccountService() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    @Override
    public void add(Account account) {
        String sql = "INSERT INTO account (accountid, account, userid) VALUES (?, ?, ?)";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, account.getAccountid());
            preparedStatement.setInt(2, account.getAccount());
            preparedStatement.setInt(3, account.getUserid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAll() {
        ArrayList<Account> list = new ArrayList<>();
        Account account;
        String sql = "select * from account";
        try (Connection connection = dataBase.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int accountid = resultSet.getInt("accountid");
                int acc = resultSet.getInt("account");
                int userid = resultSet.getInt("userid");

                account = new Account(accountid, acc, userid);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account getById(int id) {
        String sql = "select * from account where accountid = ?";
        Account account = null;
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int accountid = resultSet.getInt("accountid");
                int acc = resultSet.getInt("account");
                int userid = resultSet.getInt("userid");

                account = new Account(accountid, acc, userid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        String sql = "update account set account = ?, userid = ? where accountid = ?";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, account.getAccount());
            preparedStatement.setInt(2, account.getUserid());
            preparedStatement.setInt(3, account.getAccountid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Account account) {
        String sql = "delete from account where accountid = ?";
        try (Connection connection = dataBase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, account.getAccountid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int sumAccounts() {
        int account = 0;
        String getData = "select SUM(account) as account from account";
        try (Connection connection = dataBase.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getData);

            while (resultSet.next()) {
                account = resultSet.getInt("account");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
