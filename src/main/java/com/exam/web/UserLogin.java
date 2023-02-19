package com.exam.web;

public class UserLogin {

	private String username;
	private String password;
	private String code;
	public UserLogin(String username, String password,String code) {
		super();
		this.username = username;
		this.password = password;
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + ", code=" + code + "]";
	}
	
	

}

