package com.exam.web.course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.db.DBUtil;


/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/courseLogin")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private ResultSet rst;
	   private Connection con;
	   private PreparedStatement pst;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		PrintWriter out = response.getWriter();
		String email=request.getParameter("username");
		String pass=request.getParameter("password");
		CourseLogin c = new CourseLogin(email,pass);
		int flag=0,k=0;
			   try {
					con = DBUtil.getConnection();
					if(flag==0 || k>0) {
					pst = con.prepareStatement("INSERT INTO Course_access VALUES(?,?)");
					pst.setString(1, email);
					pst.setString(2, pass);
					pst.executeUpdate();
					flag=1;
					k++;
					}
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			   if(k>0) {
				   response.sendRedirect("index.html");
			   }else {
				   out.print("Nothing");
			   }
		   }
	}
