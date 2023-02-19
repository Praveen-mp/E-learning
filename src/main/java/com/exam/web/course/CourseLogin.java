package com.exam.web.course;

public class CourseLogin {
       private String email;
       private String password;
	public CourseLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CourseLogin [email=" + email + ", password=" + password + "]";
	}
   public static void main(String[] args) {
	   CourseLogin c = new CourseLogin("hello@gmail.com","test");
	   System.out.println(c.getEmail()+" "+c.getPassword());
}	
}

