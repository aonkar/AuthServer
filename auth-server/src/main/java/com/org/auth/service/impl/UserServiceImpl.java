package com.org.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.auth.dao.UserDAO;
import com.org.auth.entity.User;
import com.org.auth.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserDAO userDAO;

	@Override
	public User findByName(String userName) {
		return userDAO.findByName(userName);
	}
	
	@Override
	public List<User> listOfUsers() {
		return userDAO.listOfUsers();
	}


}
