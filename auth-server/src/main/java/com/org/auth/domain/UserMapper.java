package com.org.auth.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.org.auth.model.User;



public class UserMapper  implements RowMapper<User> {
	
	@Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		user.setUserName(rs.getString("username"));
		user.setRole(rs.getString("role"));
		user.setPassword(rs.getString("password"));
		user.setAge(rs.getInt("age"));
		user.setSalary(rs.getDouble("salary"));
        return user;
    }

}
