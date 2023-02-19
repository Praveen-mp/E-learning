package com.exam.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//import com.exam.db.LoginDAo;
import com.exam.db.LoginDa;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String code="null";
		PrintWriter out = response.getWriter();
		UserLogin user = new UserLogin(username, password,code);
		
		LoginDa loginDAO = new LoginDa();
		String result = "";
		try {
			result = loginDAO.authenticateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(result.equals("success")) {
//			request.getRequestDispatcher("success.html").forward(request, response);
			response.sendRedirect("index.html");
		}else {
//			response.sendRedirect("error.html");
			out.print("nothing");
		}
		
	}
}
