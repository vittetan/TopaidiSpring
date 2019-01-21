package topaidi.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;

public class CommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Comment.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Comment comment = (Comment) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Your comment shouldn't be empty. Thanks!");
		
	}
	
}
