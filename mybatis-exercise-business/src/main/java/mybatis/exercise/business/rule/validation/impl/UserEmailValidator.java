package mybatis.exercise.business.rule.validation.impl;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "userEmailValidator")
@Component
public class UserEmailValidator implements Validator<User>{

	@Override
	public void validate(User value) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		String email = value.getEmailAddress();
		boolean isValidEmail = emailValidator.isValid(email);
		if(!isValidEmail){
			String errorMsg = String.format("%s is not a valid email adress",email);
			throw new InvalidUserDataException(errorMsg);
		}
	}

}
