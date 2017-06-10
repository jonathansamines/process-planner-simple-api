package com.jonathansamines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionManager, handles every connection to MYSQL server
 to make it easier to handling connection resources.
 * @author Jonathan Samines
 */
public class ConnectionManager {
    
    private static final String connectionUri = "jdbc:oracle:thin:@service-oracle:2500";
    private static final String connectionClassName = "oracle.jdbc.driver.OracleDriver";
    private static final String databaseName = "xe";
    private static final String username = "jonathansamines";
    private static final String password = "password";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(connectionClassName);

            return DriverManager.getConnection(connectionUri + ":" + databaseName, username, password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
}