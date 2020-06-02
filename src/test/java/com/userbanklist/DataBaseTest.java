package com.userbanklist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

public class DataBaseTest {

    private DataBase dataBase;

    @Before
    public void init(){
        dataBase = DataBase.getInstance();
    }

    @Test
    public void testConnection() throws Exception{
        Connection connection = dataBase.getConnection();
        Assert.assertNotNull(connection);
        connection.close();
    }
}
