package com.userbanklist.servlets;

import com.userbanklist.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataofAllUsers extends HttpServlet {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public void init() throws ServletException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String title = "Data users";
        String docType = "<!DOCTYPE html>";

        String getData = "select user.userid, name, sureName, account from user, account\n" +
                "    where user.userid = account.userid";
        try (Connection connection = dataBase.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(getData);

            writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
            writer.println("<h1>USERS DATA</h1>");
            writer.println("<br/>");

            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String sureName = resultSet.getString("sureName");
                int account = resultSet.getInt("account");

                writer.println("Id: " + userid + "<br/>");
                writer.println("Name: " + name + "<br/>");
                writer.println("SureName: " + sureName + "<br/>");
                writer.println("account: " + account + "<br/>");
                writer.println("-------------------<br/>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {

    }
}



