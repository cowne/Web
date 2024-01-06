package com.thinhnee.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private static String jbdcURL = "jdbc:mysql://localhost:3306/test";
    private static String jbdcUsername = "root";
    private static String jbdcPassword = "root";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jbdcURL,jbdcUsername,jbdcPassword);
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
