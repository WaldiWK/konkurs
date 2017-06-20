package pl.kuranc.demo.konkurs.service.userservice;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kuranc.demo.konkurs.controller.UserDTO;
import pl.kuranc.demo.konkurs.domain.User;
import pl.kuranc.demo.konkurs.domain.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository=userRepository;
	}

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


	@Transactional
	@Override
	public User createUser(@Valid UserDTO userDTO) throws EmailExistsException {
		logger.info("###################" + userDTO.toString());
		logger.info("###################" + userDTO.getEmail());
		if(userRepository.existsByEmail(userDTO.getEmail())){
			throw new EmailExistsException("There is already an account with email adress: " + userDTO.getEmail());
		} else {
			User user = new User();
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setEnabled(userDTO.isEnabled());
			if (userDTO.isAdmin()) {
				user.setRole("ROLE_ADMIN");
			} else {
				user.setRole("ROLE_USER");
			}
			User userCreated = userRepository.save(user);
			logger.info("User created:" + userCreated.toString());
			return userCreated;
		}
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) throws EmailNotExistsException {
		User user = null;
		if (emailExists(email)) {
			List<User> users = userRepository.findByEmail(email);
			user = users.get(0);
		} else {
			throw new EmailNotExistsException("There are no users with email: " + email);
		}
		return user;
	}

	@Transactional
	@Override
	public void deleteUser(User user){
		userRepository.delete(user);
	}

	@Override
	@Transactional
	public boolean emailExists(String email) {	
		logger.info("#########################"+email+"#######################");
		return userRepository.existsByEmail(email);
	}

	@Override
	public List<UserDTO> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
