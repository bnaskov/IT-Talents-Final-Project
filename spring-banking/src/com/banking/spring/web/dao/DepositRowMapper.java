package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepositRowMapper implements RowMapper<Deposit> {

	@Override
	public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Deposit deposit = new Deposit();

		deposit.setUsername(rs.getString("username"));
		deposit.setAmount(rs.getDouble("amount"));
		deposit.setIban(rs.getString("iban"));
		deposit.setId(rs.getInt("id"));
		deposit.setDuration(rs.getInt("duration"));
		deposit.setInterest(rs.getDouble("interest"));

		return deposit;
	}
}
