package com.banking.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.banking.spring.web.utils.IbanGenerator;
import com.banking.spring.web.utils.RandomInRange;

@Component("usersDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public void create(User user) {

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("name", user.getName());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());

		MapSqlParameterSource paramAccount = new MapSqlParameterSource();
		paramAccount.addValue("iban", IbanGenerator.generateIban());
		paramAccount.addValue("amount", RandomInRange.randomAccountSum());
		paramAccount.addValue("username", user.getUsername());

		jdbc.update(
				"INSERT INTO users (username, name, password, email, enabled, authority) VALUES (:username, :name, :password, :email, :enabled, :authority)",
				params);

		jdbc.update(
				"INSERT INTO accounts (iban, amount, username) VALUES (:iban, :amount, :username)",
				paramAccount);
	}

	public boolean exists(String username) {
		return jdbc.queryForObject(
				"SELECT count(*) FROM users WHERE username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		return jdbc.query("SELECT * FROM users", new UserRowMapper());
	}

}
