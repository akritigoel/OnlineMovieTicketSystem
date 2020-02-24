package com.capgemini.onlinemovie.entities;


public class Login {

	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + ", userType=" + userType + "]";
	}

	private int id;
	private String password;
	private String userType;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public Login() {
	}
	
	public Login(int id, String password, String userType) {
		super();
		this.id = id;
		this.password = password;
		this.userType = userType;
	}
	
}

