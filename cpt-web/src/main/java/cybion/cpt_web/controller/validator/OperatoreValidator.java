package cybion.cpt_web.controller.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cybion.cpt_web.controller.command.LoginCommand;

public class OperatoreValidator implements Validator {

	
	public boolean supports(Class arg0) {
		return LoginCommand.class.equals(arg0);
	}
	
	/* Valida username e password
	 * ritorna un errore se sono vuoti o con spazi
	 * (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", "username.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "password.empty");
	}
}
