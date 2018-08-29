package com.org.auth.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.org.auth.dao.UserDAO;
import com.org.auth.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User findByName(String userName){
		Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE user_name = ?", User.class);
	    query.setParameter(1, userName);
		return (User) query.getSingleResult();
	}
	
	@Override
	public List<User> listOfUsers() {
		Query query = entityManager.createNativeQuery("SELECT * FROM users", User.class);
		return (List<User>) query.getResultList();
	}

}
