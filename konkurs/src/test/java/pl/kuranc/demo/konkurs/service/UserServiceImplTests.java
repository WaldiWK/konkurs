package pl.kuranc.demo.konkurs.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kuranc.demo.konkurs.controller.UserDTO;
import pl.kuranc.demo.konkurs.domain.User;
import pl.kuranc.demo.konkurs.service.userservice.EmailExistsException;
import pl.kuranc.demo.konkurs.service.userservice.EmailNotExistsException;
import pl.kuranc.demo.konkurs.service.userservice.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-config.xml", "/spring/security-config.xml" })
public class UserServiceImplTests {

	private String testEmail = "test@test.pl";
	private String otherTestEmail = "other@test.pl";

	UserDTO userDTO, otherUserDTO;

	@Autowired
	UserService userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		userDTO = crearteUserDTO(testEmail);
		otherUserDTO = crearteUserDTO(otherTestEmail);
	}

	@After
	public void tearDown() throws EmailNotExistsException {
		deleteUser(userDTO);
		deleteUser(otherUserDTO);
	}

	@Test
	public void testCreateUser() throws EmailExistsException {

		// create User
		User user = null;
		user = userService.createUser(userDTO);
		assertNotNull("User null - not created", user);
	}

	@Test
	public void testFindUser() throws EmailNotExistsException, EmailExistsException {
		User user = userService.createUser(userDTO);
		user = null;
		user = userService.findUserByEmail(userDTO.getEmail());
		assertNotNull("User null - not created", user);
	}

	@Test
	public void testDeleteUser() throws EmailNotExistsException, EmailExistsException {
		userService.createUser(userDTO);
		User user = userService.findUserByEmail(userDTO.getEmail());
		userService.deleteUser(user);
		// check deleted
		user = null;
		thrown.expect(EmailNotExistsException.class);
		user = userService.findUserByEmail(userDTO.getEmail());
		assertNull("User not deleted", user);
	}

	@Test
	public void testEmailExists() throws EmailExistsException {
		User user = userService.createUser(userDTO);
		assertTrue("Created user's email not found", userService.emailExists(testEmail));
		userService.deleteUser(user);
		assertFalse("found email of deleted user", userService.emailExists(testEmail));
	}

	@Test
	public void testEmailExistsException() throws EmailExistsException {
		userService.createUser(userDTO);
		thrown.expect(EmailExistsException.class);
		userService.createUser(userDTO);
	}

	@Test
	public void testEmailNotExistsException() throws EmailNotExistsException {
		thrown.expect(EmailNotExistsException.class);
		userService.findUserByEmail(userDTO.getEmail());
	}

	/*
	 * Delete persisted User (if exists)
	 */
	private void deleteUser(UserDTO userDTO) throws EmailNotExistsException {
		User user = null;
		if (userService.emailExists(userDTO.getEmail())) {
			user = userService.findUserByEmail(userDTO.getEmail());
			userService.deleteUser(user);
		}

	}

	/*
	 * Creating test userDTO W przyszłości sprawdzić jak zrobić w formie beana z
	 * parametrami ładowanego automatycznie z xml
	 */
	private UserDTO crearteUserDTO(String email) {
		UserDTO userDTO = new UserDTO();
		userDTO.setAdmin(true);
		userDTO.setEmail(email);
		userDTO.setPassword("test");
		userDTO.setMatchingPassword(userDTO.getPassword());
		userDTO.setEnabled(true);
		return userDTO;
	}
}
