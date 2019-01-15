package topaidi.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import topaidi.app.model.persons.Brain;

public class BrainValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Brain.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", "Please insert your email. Thanks!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Please insert your password. Thanks!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pseudo", "pseudo.empty", "Please choose a pseudo. Thanks!");
		Brain brain = (Brain) target;
		if(brain.getPseudo().equalsIgnoreCase("pseudo")) {
		errors.rejectValue("pseudo", "pseudo.pseudo.notpseudoPlease", "Please, try to choose an original pseudo. Thanks!");
		}
		if(brain.getPassword().length()<= 4) {
			errors.rejectValue("password", "password.password.notpasswordPlease", "Please, choose a password with at least 5 caracters. Thanks!");
		}
	}
	
}
