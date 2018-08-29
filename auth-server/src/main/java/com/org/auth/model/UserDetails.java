package com.org.auth.model;

import java.io.Serializable;

public class UserDetails implements Serializable {

	private static final long serialVersionUID = -3052764272669707631L;
	private String username;
	private String password;

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

}
