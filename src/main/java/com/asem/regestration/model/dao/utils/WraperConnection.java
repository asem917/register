package com.asem.regestration.model.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;


    public class WraperConnection {
        private String userName;
        private String passwored;
        private String host;
        private String databaseName;
        private Connection connection;
        private LocalDateTime c;

        public WraperConnection(String userName, String passwored, String host, String databaseName) throws SQLException {
            this.userName = userName;
            this.passwored = passwored;
            this.host = host;
            this.databaseName = databaseName;
            this.c=LocalDateTime.now();
            this.connection= DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databaseName,userName,passwored);


        }

        public LocalDateTime getC() {
            return c;
        }

        public Connection getConnection() {
            return connection;
        }
    }


