package com.example.bdd;

import com.sun.tools.javac.code.Attribute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class GetConnection {

    private String _connectionUrl = "jdbc:sqlserver://DESKTOP-2K2J7SR\\MSSQLSERVER:1433;database=[superCesi.Database.dev];database=superCesi.Database.dev";
    private Connection connection = null;

    public Connection GetConnection(){
        loadDataBase();
        try {
            connection = DriverManager.getConnection(_connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void loadDataBase(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
