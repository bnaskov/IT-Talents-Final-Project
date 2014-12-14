package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setAuthority(rs.getString("authority"));
		user.setEnabled(rs.getBoolean("enabled"));

		return user;
	}

}
