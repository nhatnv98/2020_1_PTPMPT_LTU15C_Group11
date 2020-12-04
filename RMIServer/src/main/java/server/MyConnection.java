/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author HK
 */
public class MyConnection {
    // create a function to connect with mysql database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/atm";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static Connection getConnection() {
//    public static void main(String args[]) {
        Connection con = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("connect failure!");
        }
        return con;
    }
}
