package com.example.product_order_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMariaDBConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mariadb://localhost:3306/mydatabase";
        String user = "root";
        String password = "1234";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("✅ 연결 성공!");
        conn.close();
    }
}
