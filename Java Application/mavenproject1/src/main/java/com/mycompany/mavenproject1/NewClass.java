/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hayar.abderrafia
 */
public class NewClass {
      public static void main(String[] args) {
        connect();
    }
     private static Connection connect() {
        // SQLite connection string

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost", "abde", "abde");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
}
