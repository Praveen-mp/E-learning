package com.exam.db;

import java.sql.*;

import com.exam.web.course.CourseLogin;


public class CourseValidate {
	   private ResultSet rs;
	   private Connection con;
	   private PreparedStatement pst;
       public String authenticateUser(CourseLogin user) throws SQLException {
    	con=DBUtil.getConnection();
    	pst=con.prepareStatement("select email from Course_access where password=?");
    	rs=pst.executeQuery();
        pst.setString(1, user.getEmail());
        System.out.print(rs.getString(1)+" "+user.getPassword());
        while(rs.next()) {
        	if(user.getPassword().equals(rs.getString(1))) {
        		return "success";
        	}
        }
		return "error";
    	   
       }
}
