package mybatis.exercise.business.rule.validation;

import org.junit.Before;
import org.junit.Test;

import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.rule.validation.impl.UserEmailValidator;
import mybatis.exercise.persistence.domain.User;

public class UserEmailValidatorTest {

	private static final String VALID_EMAIL_ADDRESS = "test@test.com";
	private static final String INVALID_EMAIL_ADDRESS = "test";
	private Validator<User> userEmailValidator;

	@Before
	public void init() {
		userEmailValidator = new UserEmailValidator();
	}

	@Test(expected = InvalidUserDataException.class)
	public void testValidateEmptyEmail() {
		User testUser = new User();
		testUser.setEmailAddress(null);
		userEmailValidator.validate(testUser);
	}

	@Test
	public void testValidateCorrectEmail() {
		User testUser = new User();
		testUser.setEmailAddress(VALID_EMAIL_ADDRESS);
		userEmailValidator.validate(testUser);
	}

	@Test(expected = InvalidUserDataException.class)
	public void testValidateWrongEmail() {
		User testUser = new User();
		testUser.setEmailAddress(INVALID_EMAIL_ADDRESS);
		userEmailValidator.validate(testUser);
	}
}
