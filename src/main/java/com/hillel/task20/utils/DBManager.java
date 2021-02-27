package com.hillel.task20.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBManager {
    public static final String DATABASE_DRIVER_NAME = "DATABASE_DRIVER_NAME";
    public static final String DATABASE_URL = "DATABASE_URL";
    public static final String USER_NAME = "USER_NAME";
    public static final String PASSWORD = "PASSWORD";

    public String getProperty(String key) {
        Properties properties = new Properties();
        String fileName = "config.properties";
        try {
            InputStream in = DBManager.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
