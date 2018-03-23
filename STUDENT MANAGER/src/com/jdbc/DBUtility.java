package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			// Store the database URL in a string
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				 connection=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/students","root","admin");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}