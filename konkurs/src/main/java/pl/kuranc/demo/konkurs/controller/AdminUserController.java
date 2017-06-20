package pl.kuranc.demo.konkurs.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import pl.kuranc.demo.konkurs.service.userservice.EmailExistsException;
import pl.kuranc.demo.konkurs.service.userservice.UserService;

@Controller
@RequestMapping("admin/")
public class AdminUserController {

	private Logger logger = LoggerFactory.getLogger(AdminUserController.class);	
	private final UserService userService;
	
	@Autowired
	public AdminUserController( UserService userService) {
		this.userService = userService;
		
	}
	
	@RequestMapping(value="user", method = RequestMethod.GET)
	public String listUsers(Model model){
		List<UserDTO> users = userService.getUsers();
		model.addAttribute("users", users);
		return "admin/userList";
	}
	
	
	/*
	 * Dodaje nowego użytkownika
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public String addUserGet(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "admin/userForm";
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public ModelAndView addUserPost(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result,
			WebRequest request, Errors errors)  {

		if (result.hasErrors()) {
			// Nie udało się przesłać egzemplarza UserDTO bo błędnie wypełniony
			// formularz
			logger.info("Błąd przesyłania formularza, informacje z result:");
			logger.info(result.toString());
			return new ModelAndView("admin/userForm", "user", userDTO);
		} else {
			logger.info("******************" + userDTO.toString());
			try {
				userService.createUser(userDTO);
			} catch (EmailExistsException e) {
				result.rejectValue("email", "error.email", "email already exists");
				return new ModelAndView("admin/userForm", "user", userDTO);
			}
			// formularz wypełniony prawidłowo i użytkownik zarejestrowany
			logger.info("***************User: " + userDTO.toString() + "  send from form");
			return new ModelAndView("admin/successRegister");
		}
	}

}
