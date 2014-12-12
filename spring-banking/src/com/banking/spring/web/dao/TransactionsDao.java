package com.banking.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("transactionsDao")
public class TransactionsDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Transaction> getAmountFromIban(String iban) {
		return jdbc.query("select amount from accounts where iban=:iban",
				new MapSqlParameterSource("iban", iban),
				new RowMapper<Transaction>() {

					@Override
					public Transaction mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Transaction transaction = new Transaction();
						transaction.setAmount(rs.getDouble("amount"));

						return transaction;
					}
				});
	}

	@Transactional
	public void create(Transaction transaction) {

		MapSqlParameterSource transactionParams = new MapSqlParameterSource();

		transactionParams.addValue("date", transaction.getDate());
		transactionParams.addValue("time", transaction.getTime());
		transactionParams.addValue("initiatoriban",
				transaction.getInitiatorIban());
		transactionParams.addValue("recipientiban",
				transaction.getRecipientIban());
		transactionParams.addValue("amount", transaction.getAmount());
		transactionParams.addValue("reason", transaction.getReason());

		Transaction tempTransaction = getAmountFromIban(
				transaction.getInitiatorIban()).get(0);

		MapSqlParameterSource initiatorAccount = new MapSqlParameterSource();
		initiatorAccount.addValue("amountBefore", tempTransaction.getAmount());
		initiatorAccount.addValue("amount", transaction.getAmount());
		initiatorAccount.addValue("iban", transaction.getInitiatorIban());

		jdbc.update(
				"update accounts set amount=(:amountBefore-:amount) where iban=:iban",
				initiatorAccount);

		jdbc.update(
				"insert into transactions (date, time, initiatoriban, recipientiban, amount, reason) values (:date, :time, :initiatoriban, :recipientiban, :amount, :reason)",
				transactionParams);

	}
}
