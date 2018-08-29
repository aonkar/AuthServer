package com.org.auth.dao;

import java.util.List;

import com.org.auth.entity.User;

public interface UserDAO {

	public User findByName(String userName);
	public List<User> listOfUsers();

}
