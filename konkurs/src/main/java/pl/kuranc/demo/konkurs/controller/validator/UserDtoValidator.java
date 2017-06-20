package pl.kuranc.demo.konkurs.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.kuranc.demo.konkurs.controller.UserDTO;

public class UserDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object userDTO, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password can't be empty");
	}

}
