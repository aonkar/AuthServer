package com.org.auth.service;

import java.util.List;

import com.org.auth.entity.User;

public interface UserService {
	
	User findByName(String userName);
	List<User> listOfUsers();
	
}
