package pl.kuranc.demo.konkurs.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kuranc.demo.konkurs.domain.User;
import pl.kuranc.demo.konkurs.domain.UserRepository;
import pl.kuranc.demo.konkurs.service.userservice.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-config.xml", "/spring/security-config.xml" })
public abstract class UserRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository repository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	

	@Test
	public void findByEmailTest() {
		List<User> users = (List<User>) repository.findByEmail("test@test.pl");
		logger.error("users:"+users.toString());
		repository.delete(users);
	}
	
	
	
	

}
