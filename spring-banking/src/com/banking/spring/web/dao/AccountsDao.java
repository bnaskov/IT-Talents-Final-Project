package com.banking.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("accountsDao")
public class AccountsDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Account> getAccounts(String username) {

		return jdbc.query("select * from accounts where username=:username",
				new MapSqlParameterSource("username", username),
				new AccountRowMapper());
	}

	public boolean exists(String recipientIban) {
		// TODO Auto-generated method stub
		return jdbc
				.queryForObject(
						"select count(*) from accounts where iban=:iban",
						new MapSqlParameterSource("iban", recipientIban),
						Integer.class) > 0;
	}
}
