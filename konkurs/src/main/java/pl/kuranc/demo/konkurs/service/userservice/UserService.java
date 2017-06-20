package pl.kuranc.demo.konkurs.service.userservice;


import java.util.List;

import pl.kuranc.demo.konkurs.controller.UserDTO;
import pl.kuranc.demo.konkurs.domain.User;

public interface UserService {
	
	public User createUser(UserDTO userDTO) throws EmailExistsException;

	public User findUserByEmail(String email) throws EmailNotExistsException;	               

	public void deleteUser(User user) ;
	
	public boolean emailExists(String email);

	public List<UserDTO> getUsers();
	
	
/*	
	public List<User> getUsers();
	public User getUser(Long id);
	public User checkUser(String username, String password);
	public User updateUser(User user);
*/	

}
  