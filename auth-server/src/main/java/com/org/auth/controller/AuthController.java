package com.org.auth.controller;

import java.security.InvalidKeyException;
import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.auth.entity.User;
import com.org.auth.model.UserDetails;
import com.org.auth.security.JwtTokenUtil;
import com.org.auth.service.UserService;

import io.jsonwebtoken.Claims;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    UserService userService;

	@RequestMapping(value = "/generateToken", method = RequestMethod.POST, consumes="application/json")
	public String verifyOrGenerateToken(@RequestBody UserDetails user) throws SignatureException {
		User daoUser = userService.findByName(user.getUsername()); //Plug in siteminder or LDAP if required
		if(null == daoUser){
			return "invalid user, Please enter valid credentials";
		}else{
			return jwtTokenUtil.generateToken(daoUser);
		}
	}

	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST, consumes="text/plain")
	public @ResponseBody Boolean validateToken(@RequestBody String token) throws InvalidKeyException {
		return jwtTokenUtil.validateToken(token);
	}
/*	
	@RequestMapping(value = "/refreshToken", method = RequestMethod.POST, consumes="text/plain")
	public @ResponseBody String refreshToken(@RequestBody String token) throws Exception {
		return jwtTokenUtil.refreshToken(token);
	}*/
	
	@RequestMapping(value = "/returnTokenClaims", method = RequestMethod.POST, produces="application/json", consumes="text/plain")
	public @ResponseBody Claims returnTokenClaims(@RequestBody String token) throws InvalidKeyException {
		return jwtTokenUtil.getClaimsFromToken(token);
	}

}
