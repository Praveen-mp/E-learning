package com.exam.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.web.UserLogin;

//import jakarta.servlet.annotation.WebServlet;


public class LoginDa {
    private ResultSet rs;
	private Connection con;

	public String authenticateUser(UserLogin user) throws SQLException {
		
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select password from COURSE_ACCESS where email=?");
			pst.setString(1,user.getUsername());
			rs = pst.executeQuery();
//			System.out.print(rs.getString(1));
//			System.out.print(rs.getString(1)+" "+user.getPassword());
			while(rs.next()) {
				System.out.print(rs.getString(1)+" "+user.getPassword());
				if(user.getPassword().equals(rs.getString(1))) {
					return "success";
				}
			}
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			System.out.print(user.getPassword()+" "+rs.getString(1));
		}
		return "error";
	}
	
}
