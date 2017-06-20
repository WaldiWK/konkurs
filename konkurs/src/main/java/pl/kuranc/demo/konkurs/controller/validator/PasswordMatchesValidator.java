package pl.kuranc.demo.konkurs.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.kuranc.demo.konkurs.controller.UserDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	
	

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDTO user = (UserDTO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
