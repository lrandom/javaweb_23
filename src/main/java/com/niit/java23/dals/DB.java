package com.niit.java23.dals;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/book_shop?autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "koodinh@";

    protected Connection connection;
    protected String tableName = "";

    public void openConnection() {
        try {
            System.out.println("Connection");
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DB() {
        openConnection();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
