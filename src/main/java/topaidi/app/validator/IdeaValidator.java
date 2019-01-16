package topaidi.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;

public class IdeaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Brain.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Idea idea = (Idea) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty", "Please choose a title for you idea. Thanks!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Please, give us some details about your idea. Thanks!");
		if(idea.getTitle().length()<= 5) {
			errors.rejectValue("title", "title.title.notpasswordPlease", "Please, choose a more descriptive title. Thanks!");
		}
		if(idea.getDescription().length()<= 100) {
			errors.rejectValue("description", "description.description.notpasswordPlease", "Please, choose a more detailed description. Thanks!");
		}
		if(idea.getDescription().length()>= 256) {
			errors.rejectValue("description", "description.description.notpasswordPlease", "Sorry, it's taking a bit long to share this idea. Thanks!");
		}
	}
	
}
