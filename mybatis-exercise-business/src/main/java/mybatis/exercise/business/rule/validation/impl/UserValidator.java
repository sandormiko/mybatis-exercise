package mybatis.exercise.business.rule.validation.impl;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.rule.validation.api.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "userValidator")
@Component
public class UserValidator implements Validator<User> {

	private Validator<User> userEmailValidator;
	private Validator<User> userAgeValidator;
	
	@Autowired
	public UserValidator(
			@Qualifier(value = "userEmailValidator") Validator<User> aUserEmailValidator,
			@Qualifier(value = "userAgeValidator") Validator<User> aUserAgeValidator) {
		this.userEmailValidator = aUserEmailValidator;
		this.userAgeValidator = aUserAgeValidator;
	}
	
	@Override
	public void validate(User user) {
		userAgeValidator.validate(user);
		userEmailValidator.validate(user);
	}

	
	

}
