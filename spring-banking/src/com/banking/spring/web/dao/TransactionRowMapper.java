package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = new Transaction();

		transaction.setDate(rs.getDate("date"));
		transaction.setTime(rs.getTime("time"));
		transaction.setInitiatorIban(rs.getString("initiatoriban"));
		transaction.setRecipientIban(rs.getString("recipientiban"));
		transaction.setAmount(rs.getDouble("amount"));
		transaction.setReason(rs.getString("reason"));

		return transaction;
	}

}
