package com.banking.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.banking.spring.web.dao.Account;
import com.banking.spring.web.dao.AccountsDao;
import com.banking.spring.web.dao.Deposit;
import com.banking.spring.web.dao.DepositsDao;
import com.banking.spring.web.dao.Transaction;
import com.banking.spring.web.dao.TransactionsDao;
import com.banking.spring.web.dao.User;
import com.banking.spring.web.dao.UsersDao;
import com.banking.spring.web.utils.DateTime;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/banking/spring/web/config/dao-context.xml",
		"classpath:com/banking/spring/web/config/security-context.xml",
		"classpath:com/banking/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionDaoTest {
	private static final double DELTA = 1e-15;

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private AccountsDao accountsDao;

	@Autowired
	private TransactionsDao transactionsDao;

	@Autowired
	private DepositsDao depositsDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from deposits");
		jdbc.execute("delete from accounts");
		jdbc.execute("delete from users");
		jdbc.execute("delete from transactions");
	}

	@Test
	public void testTransactions() {
		User ivan = new User("ivanivanov", "Ivan Ivanov", "12345678",
				"ivan@abv.bg", true, "ROLE_USER");

		usersDao.create(ivan);

		String ivanUsername = ivan.getUsername();
		List<Account> accountsIvan = accountsDao.getAccounts(ivanUsername);
		Account a1 = accountsIvan.get(0);

		User george = new User("georgeivanov", "George Ivanov", "12345678",
				"george@abv.bg", true, "ROLE_USER");

		usersDao.create(george);

		String georgeUsername = george.getUsername();
		List<Account> accountsGeorge = accountsDao.getAccounts(georgeUsername);
		Account a2 = accountsGeorge.get(0);

		System.out.println(a1);

		double moneyIvanAccountBeforeTransaction = a1.getAmount();
		double moneyGeorgeAccountBeforeTransaction = a2.getAmount();

		Transaction t1 = new Transaction(DateTime.getCurrentDate(),
				DateTime.getCurrentTime(), a1.getIban(), a2.getIban(),
				"Merry Christmas!", 1000);

		transactionsDao.createBankClientTransaction(t1);

		accountsIvan = accountsDao.getAccounts(ivanUsername);
		a1 = accountsIvan.get(0);
		accountsGeorge = accountsDao.getAccounts(georgeUsername);
		a2 = accountsGeorge.get(0);

		double moneyIvanAccountAfterTransaction = a1.getAmount();
		double moneyGeorgeAccountAfterTransaction = a2.getAmount();

		List<Transaction> accountTransactions = transactionsDao
				.getAccountTransactions(a1.getIban());

		assertEquals("Account transactions should be 1.", 1,
				accountTransactions.size());

		assertEquals(
				"Ivan's money after transaction should be a 1000 less than before transaction",
				moneyIvanAccountAfterTransaction,
				moneyIvanAccountBeforeTransaction - 1000, DELTA);

		assertEquals(
				"George's money after transaction should be a 1000 more than before transaction",
				moneyGeorgeAccountAfterTransaction,
				moneyGeorgeAccountBeforeTransaction + 1000, DELTA);

		String georgeAccountIbanString = a2.getIban();

		assertEquals(
				"Method getAmountForIban(String iban) must return the amount of money for the specific account",
				transactionsDao.getAmountForIban(georgeAccountIbanString),
				a2.getAmount(), DELTA);

		Deposit georgeDeposit = new Deposit(1, "BG80ITOB93003502425012", 1500,
				"georgeivanov", 3, 4, DateTime.getCurrentDate(),
				DateTime.getDateAfter(3));
		Transaction t2 = new Transaction(DateTime.getCurrentDate(),
				DateTime.getCurrentTime(), a1.getIban(),
				"BG80ITOB93003502425012", "Merry Christmas!", 1500);

		transactionsDao.createDeposit(t2, georgeDeposit);

		List<Deposit> userDeposits = depositsDao.getDeposits("georgeivanov");

		assertEquals("George should have 1 deposit.", 1, userDeposits.size());

		assertEquals("The two deposits should be equal", userDeposits.get(0),
				georgeDeposit);

	}
}
