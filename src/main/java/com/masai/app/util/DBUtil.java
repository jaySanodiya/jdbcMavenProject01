package com.masai.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection provideConnection() {
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
		
	}

}
