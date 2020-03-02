package com.asem.regestration.model.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Queue;

public class DataSourcePool {

    private Queue2 pool= Queue2.getInstance();
    private String userName;
    private String passwored;
    private String host;
    private String databaseName;
    private Connection connection;


    public DataSourcePool(String userName, String passwored, String host, String databaseName) {
        this.userName = userName;
        this.passwored = passwored;
        this.host = host;
        this.databaseName = databaseName;

    }

    public  WraperConnection getConnections() throws SQLException {
        if (pool.isEmpty())
            return  new WraperConnection(userName,passwored,host,databaseName) ;
        else {
            WraperConnection temp = pool.deQueue();
            if (temp.getC().plusHours(6).compareTo(LocalDateTime.now()) >= 0)
                return temp;
            else
                temp.getConnection().close();
            return getConnections();

        }
    }
    public void releasConnection(WraperConnection c){
        pool.enQueue(c);
    }
}




