package utils;

import logic.User;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserEntryValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object command, Errors errors) {
		
		User user = (User) command;
		
		if(!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");  //error.required.user.userId의 메세지가 출력
		}

		if(!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required"); //error.required.user.password의 메세지가 출력
		}

		if(!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required");
		}

		if(!StringUtils.hasText(user.getPostCode())) {
			errors.rejectValue("postCode", "error.required");
		}

		if(!StringUtils.hasText(user.getAddress())) {
			errors.rejectValue("address", "error.required");
		}

		if(!StringUtils.hasText(user.getEmail())) {
			errors.rejectValue("email", "error.required");
		}

		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
		
	}

}
