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

		return jdbc.query("SELECT * FROM accounts WHERE username=:username",
				new MapSqlParameterSource("username", username),
				new AccountRowMapper());
	}

	public boolean exists(String recipientIban) {
		return jdbc
				.queryForObject(
						"SELECT count(*) FROM accounts WHERE iban=:iban",
						new MapSqlParameterSource("iban", recipientIban),
						Integer.class) > 0;
	}

	public double getAmmountForIban(String iban) {

		Account account = (Account) jdbc
				.query("SELECT FIRST(amount) FROM accounts WHERE iban=:iban",
						new MapSqlParameterSource("iban", iban),
						new AccountRowMapper());

		return account.getAmount();
	}
}
