package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();

		account.setUsername(rs.getString("username"));
		account.setAmount(rs.getDouble("amount"));
		account.setIban(rs.getString("iban"));
		account.setId(rs.getInt("id"));

		return account;
	}

}
