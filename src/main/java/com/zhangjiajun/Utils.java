package com.zhangjiajun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class Utils {
    private static final String DB_CONFIG = "data.properties";

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(Utils.class.getClassLoader().getResourceAsStream(DB_CONFIG));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection(){

        try {
            Class.forName(prop.getProperty("driverClassName"));
            return DriverManager.getConnection(prop.getProperty("url"),
                    prop.getProperty("username"),prop.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
