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

	public double getAmountForIban(String iban) {
		List<Transaction> transacts = null;

		transacts = jdbc.query("select amount from accounts where iban=:iban",
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

		return transacts.get(0).getAmount();
	}

	@Transactional
	public void createBankClientTransaction(Transaction transaction) {
		MapSqlParameterSource transactionParams = new MapSqlParameterSource();

		transactionParams.addValue("date", transaction.getDate());
		transactionParams.addValue("time", transaction.getTime());
		transactionParams.addValue("initiatoriban",
				transaction.getInitiatorIban());
		transactionParams.addValue("recipientiban",
				transaction.getRecipientIban());
		transactionParams.addValue("amount", transaction.getAmount());
		transactionParams.addValue("reason", transaction.getReason());

		double initiatorAmountBeforeTransaction = getAmountForIban(transaction
				.getInitiatorIban());

		MapSqlParameterSource initiatorAccount = new MapSqlParameterSource();
		initiatorAccount.addValue("amountBefore",
				initiatorAmountBeforeTransaction);
		initiatorAccount.addValue("amount", transaction.getAmount());
		initiatorAccount.addValue("iban", transaction.getInitiatorIban());

		double recipientAmountBeforeTransaction = getAmountForIban(transaction
				.getRecipientIban());

		MapSqlParameterSource recipientAccount = new MapSqlParameterSource();
		recipientAccount.addValue("amountBefore",
				recipientAmountBeforeTransaction);
		recipientAccount.addValue("amount", transaction.getAmount());
		recipientAccount.addValue("iban", transaction.getRecipientIban());

		jdbc.update(
				"update accounts set amount=(:amountBefore-:amount) where iban=:iban",
				initiatorAccount);

		jdbc.update(
				"update accounts set amount=(:amountBefore+:amount) where iban=:iban",
				recipientAccount);

		jdbc.update(
				"insert into transactions (date, time, initiatoriban, recipientiban, amount, reason) values (:date, :time, :initiatoriban, :recipientiban, :amount, :reason)",
				transactionParams);

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

		double amountBeforeTransaction = getAmountForIban(transaction
				.getInitiatorIban());

		MapSqlParameterSource initiatorAccount = new MapSqlParameterSource();
		initiatorAccount.addValue("amountBefore", amountBeforeTransaction);
		initiatorAccount.addValue("amount", transaction.getAmount());
		initiatorAccount.addValue("iban", transaction.getInitiatorIban());

		jdbc.update(
				"update accounts set amount=(:amountBefore-:amount) where iban=:iban",
				initiatorAccount);

		jdbc.update(
				"insert into transactions (date, time, initiatoriban, recipientiban, amount, reason) values (:date, :time, :initiatoriban, :recipientiban, :amount, :reason)",
				transactionParams);

	}

	@Transactional
	public void createAccount(Transaction transaction, String username) {
		MapSqlParameterSource transactionParams = new MapSqlParameterSource();

		transactionParams.addValue("date", transaction.getDate());
		transactionParams.addValue("time", transaction.getTime());
		transactionParams.addValue("initiatoriban",
				transaction.getInitiatorIban());
		transactionParams.addValue("recipientiban",
				transaction.getRecipientIban());
		transactionParams.addValue("amount", transaction.getAmount());
		transactionParams.addValue("reason", transaction.getReason());

		double amountBeforeTransaction = getAmountForIban(transaction
				.getInitiatorIban());

		MapSqlParameterSource initiatorAccount = new MapSqlParameterSource();
		initiatorAccount.addValue("amountBefore", amountBeforeTransaction);
		initiatorAccount.addValue("amount", transaction.getAmount());
		initiatorAccount.addValue("iban", transaction.getInitiatorIban());

		MapSqlParameterSource newAccount = new MapSqlParameterSource();
		newAccount.addValue("iban", transaction.getRecipientIban());
		newAccount.addValue("amount", transaction.getAmount());
		newAccount.addValue("username", username);

		jdbc.update(
				"update accounts set amount=(:amountBefore-:amount) where iban=:iban",
				initiatorAccount);

		jdbc.update(
				"insert into accounts (iban, amount, username) values (:iban, :amount, :username)",
				newAccount);

		jdbc.update(
				"insert into transactions (date, time, initiatoriban, recipientiban, amount, reason) values (:date, :time, :initiatoriban, :recipientiban, :amount, :reason)",
				transactionParams);

	}

	public List<Transaction> getAccountTransactions(String accountIban) {

		return jdbc
				.query("SELECT * FROM transactions WHERE initiatoriban=:iban OR recipientiban=:iban",
						new MapSqlParameterSource("iban", accountIban),
						new TransactionRowMapper());
	}

}
