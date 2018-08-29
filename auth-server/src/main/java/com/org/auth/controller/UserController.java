package com.org.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.auth.entity.User;
import com.org.auth.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public List<User> login() throws Exception {
    	List<User> userList = userService.listOfUsers();
    	if (userList == null || userList.size()==0) {
    		throw new Exception("No users present in DB");
    	}
    	return userList;
    }
}
