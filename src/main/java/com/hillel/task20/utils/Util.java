package com.hillel.task20.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static DBManager dbManager = new DBManager();
    private static String driverName = dbManager.getProperty(DBManager.DATABASE_DRIVER_NAME);
    private static String url;
    private static String user;
    private static String password;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driverName);
            url = dbManager.getProperty(DBManager.DATABASE_URL);
            user = dbManager.getProperty(DBManager.USER_NAME);
            password = dbManager.getProperty(DBManager.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static void createTable() {
        try {
            try (Connection connection = Util.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS cities(" +
                        "id TEXT PRIMARY KEY NOT NULL," +
                        "name TEXT UNIQUE NOT NULL)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
