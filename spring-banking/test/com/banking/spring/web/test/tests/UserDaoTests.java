package com.banking.spring.web.test.tests;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.banking.spring.web.dao.User;
import com.banking.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/banking/spring/web/config/dao-context.xml",
		"classpath:com/banking/spring/web/config/security-context.xml",
		"classpath:com/banking/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao usersDao;

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
	public void testUsers() {
		User user = new User("ivanivanov", "Ivan Ivanov", "12345678",
				"ivan@abv.bg", true, "ROLE_USER");

		usersDao.create(user);

		// assertTrue("User creation should return true",
		// usersDao.create(user));

		// List<User> users = usersDao.getAllUsers();
		//
		// assertEquals("Number of users should be 1.", 1, users.size());

		// assertTrue("User should exist.",
		// usersDao.exists(user.getUsername()));

		// assertEquals("Created user should be identical to retrieved user",
		// user, users.get(0));

	}

}
