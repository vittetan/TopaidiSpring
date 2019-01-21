package topaidi.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import topaidi.app.model.reports.Report;

public class ReportValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Report.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Report report = (Report) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty", "Your comment shouldn't be empty. Thanks!");
		
	}
	
}
