package com.example.springSessionSample;

public class User {

	
	public User(String userName, String userCountry) {
		super();
		this.userName = userName;
		this.userCountry = userCountry;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String userName;
	private String userCountry;
	
}
