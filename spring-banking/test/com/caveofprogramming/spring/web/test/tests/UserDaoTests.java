package com.caveofprogramming.spring.web.test.tests;


//@ActiveProfiles("dev")
//@ContextConfiguration(locations = {
//		"classpath:com/caveofprogramming/spring/web/config/dao-context.xml",
//		"classpath:com/caveofprogramming/spring/web/config/security-context.xml",
//		"classpath:com/caveofprogramming/spring/web/test/config/datasource.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserDaoTests {
//
//	@Autowired
//	private UsersDao usersDao;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Before
//	public void init() {
//		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//
//		jdbc.execute("delete from offers");
//		jdbc.execute("delete from users");
//	}
//
//	@Test
//	public void testUsers() {
//		User user = new User("johnwpurcell", "John Purcell", "hellothere",
//				"john@caveofprogramming.com", true, "user");
//
//		assertTrue("User creation should return true", usersDao.create(user));
//
//		List<User> users = usersDao.getAllUsers();
//
//		assertEquals("Number of users should be 1.", 1, users.size());
//
//		assertTrue("User should exist.", usersDao.exists(user.getUsername()));
//
//		assertEquals("Created user should be identical to retrieved user",
//				user, users.get(0));
//
//	}
//
// }
