package com.banking.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import com.banking.spring.web.dao.User;
import com.banking.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/banking/spring/web/config/dao-context.xml",
		"classpath:com/banking/spring/web/config/security-context.xml",
		"classpath:com/banking/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTests {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private AccountsDao accountsDao;

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
	public void testAccounts() {
		User user = new User("ivanivanov", "Ivan Ivanov", "12345678",
				"ivan@abv.bg", true, "ROLE_USER");

		usersDao.create(user);
		String username = user.getUsername();

		List<Account> accounts = accountsDao.getAccounts(username);

		assertEquals("Number of accounts should be 1.", 1, accounts.size());

		assertTrue("Account should exist.",
				accountsDao.exists(accounts.get(0).getIban()));

	}

}
