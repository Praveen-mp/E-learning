package com.exam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection con;
	public static Connection getConnection() {
		try {
			if(con==null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","System","Praveen");
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}
		return con;

	}
	
   
	
}
