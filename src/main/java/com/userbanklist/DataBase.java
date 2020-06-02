package com.userbanklist;

import java.sql.*;

public class DataBase {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/userbanklist";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static DataBase instance;

    private DataBase(){}

    public static DataBase getInstance() {
        if (instance == null){
            instance = new DataBase();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}