package com.userbanklist.service;

import com.userbanklist.Account;
import com.userbanklist.DataBase;
import com.userbanklist.dao.DAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccountServiceTest {

    private DataBase dataBase;
    private DAO dao;

    @Before
    public void init() {
        dataBase = DataBase.getInstance();
        dao = AccountService.getAccountService();
    }

    @Test
    public void testGetAllAccount() throws Exception {
        List<Account> list;
        list = dao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetAccountById() throws Exception {
        Account account;
        account = (Account) dao.getById(4);
        Assert.assertNotNull(account);
        Assert.assertTrue(account.getAccountid() == 4);
    }

    @Test
    public void testAddAccount() throws Exception {
        List<Account> list = dao.getAll();
        Account account = new Account(11, 30000, 9);
        dao.add(account);
        Assert.assertNotEquals(dao.getAll(), list.size());

    }

    @Test
    public void testUpdateAccount() throws Exception {
        int account = 987556;
        Account accountBefore = (Account) dao.getById(11);
        accountBefore.setAccount(account);
        dao.update(accountBefore);

        Assert.assertNotNull(dao.getById(11));
        Assert.assertTrue(( (Account) dao.getById(11)).getAccount() == account);
    }

    @Test
    public void testDeleteAccount() throws Exception {
        List<Account> list = dao.getAll();
        Account account = (Account) dao.getById(11);
        dao.delete(account);
        Assert.assertNotEquals(list.size(), dao.getAll());
    }
}
