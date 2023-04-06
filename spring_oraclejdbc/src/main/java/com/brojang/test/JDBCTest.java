package com.brojang.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    /*
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

    /*@Test
    public void ConnectTest() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
            System.out.println("연결 성공 : " + conn);
            conn.close();
        } catch (SQLException e) {
            System.out.println("연결 실패");
            e.printStackTrace();
        }
    }*/
}
