package com.sample.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.exam.web.UserLogin;

/**
 * Servlet implementation class CustomMailSender
 */
@WebServlet("/VerifyMail")
public class CustomMailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
		   String name= request.getParameter("email");
		   String pass=request.getParameter("password");
		   System.out.println(name+" "+pass);
		   RandomMailer r = new RandomMailer();
		   String code  = r.getRandom();
		   System.out.println(code);
		   UserLogin u = new UserLogin(name,pass,code);
//		   r.sendEmail(u);
		   boolean test=r.sendEmail(u);
		   System.out.println(test);
		   if(test) {
			   HttpSession sess = request.getSession();
			   sess.setAttribute("authcode", pass);
			   response.sendRedirect("index.html");
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
