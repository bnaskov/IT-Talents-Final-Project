package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepositRowMapper implements RowMapper<Deposit> {

	@Override
	public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Deposit deposit = new Deposit();

		deposit.setIban(rs.getString("iban"));
		deposit.setAmount(rs.getDouble("amount"));
		deposit.setDuration(rs.getInt("duration"));
		deposit.setInterest(rs.getDouble("interest"));
		deposit.setUsername(rs.getString("username"));
		deposit.setStartDate(rs.getDate("startDate"));
		deposit.setEndDate(rs.getDate("endDate"));
		deposit.setId(rs.getInt("id"));

		return deposit;
	}
}
