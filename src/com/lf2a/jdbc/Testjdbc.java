package com.lf2a.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";

        try {
            System.out.println("Conectando ao banco de dados: " + jdbcURL);

            Connection conn = DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("Conectado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
