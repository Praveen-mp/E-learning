package com.sample.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.exam.db.CourseValidate;
import com.exam.web.course.CourseLogin;

/**
 * Servlet implementation class CourseAuthenication
 */
//@WebServlet("/courseLogin")
public class CourseAuthenication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();  
		CourseValidate validation = new CourseValidate();
		CourseLogin courseDetails = new CourseLogin(email,pass);
		String result=courseDetails.getPassword();
		try {
			if(result.equals(validation.authenticateUser(courseDetails))) {
				response.sendRedirect("index.html");
			}else {
				response.sendRedirect("course.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
