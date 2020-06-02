package com.userbanklist.service;

import com.userbanklist.DataBase;
import com.userbanklist.User;
import com.userbanklist.dao.DAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private DataBase dataBase;
    private DAO dao;

    @Before
    public void init() {
        dataBase = DataBase.getInstance();
        dao = UserService.getUserService();
    }

    @Test
    public void testGetAllUser() throws Exception {
        List<User> list;
        list = dao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetUserById() throws Exception {
        User user;
        user = (User) dao.getById(4);
        Assert.assertNotNull(user);
        Assert.assertTrue(user.getId() == 4);
    }

    @Test
    public void testAddUser() throws Exception {
        List<User> list = dao.getAll();
        User user = new User(11, "Makar", "Branak");
        dao.add(user);
        Assert.assertNotEquals(dao.getAll(), list.size());

    }

    @Test
    public void testUpdateUser() throws Exception {
        String name = "Vitalik";
        User userBefore = (User) dao.getById(11);
        userBefore.setName(name);
        dao.update(userBefore);

        Assert.assertNotNull(dao.getById(11));
        Assert.assertTrue(( (User) dao.getById(11)).getName().equals(name));
    }

    @Test
    public void testDeleteUser() throws Exception {
        List<User> list = dao.getAll();
        User user = (User) dao.getById(11);
        dao.delete(user);
        Assert.assertNotEquals(list.size(), dao.getAll());
    }
}
