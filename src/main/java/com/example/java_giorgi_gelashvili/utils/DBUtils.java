package com.example.java_giorgi_gelashvili.utils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBUtils {

    private static final String DB_URL = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8588259";
    private static final String DB_USER = "sql8588259";
    private static final String DB_PASSWORD = "wVKCyyAPWg";
    private static final Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

    public static void execute(String query) {
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdate(String query) {
        try {
            getStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            return getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetIndex(String table) {
        String query = String.format("ALTER TABLE %s AUTO_INCREMENT = 1", table);
        execute(query);
    }
}
