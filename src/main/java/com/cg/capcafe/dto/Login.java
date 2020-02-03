package com.cg.capcafe.dto;

public class Login {
	
	private int capgeminiId;
	private String password;
	
	public int getCapgeminiId() {
		return capgeminiId;
	}
	public void setCapgeminiId(int capgeminiId) {
		this.capgeminiId = capgeminiId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Login() {}
	
	public Login(int capgeminiId, String password) {
		super();
		this.capgeminiId = capgeminiId;
		this.password = password;
	}
	
	
}
