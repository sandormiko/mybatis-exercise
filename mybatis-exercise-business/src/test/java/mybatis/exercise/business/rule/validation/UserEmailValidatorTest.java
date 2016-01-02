package mybatis.exercise.business.rule.validation;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.rule.validation.impl.UserEmailValidator;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserEmailValidatorTest {

	private static final String VALID_EMAIL_ADDRESS = "test@test.com";
	private static final String INVALID_EMAIL_ADDRESS = "test";
	private static Validator<User> userEmailValidator;
	private static User testUser = null;
	
	@BeforeClass
	public static void init(){
		testUser = new User();
		userEmailValidator = new UserEmailValidator();
	}
	
	@Test(expected=InvalidUserDataException.class)
	public void testValidateEmptyEmail(){
		testUser.setEmailAddress(null);
		userEmailValidator.validate(testUser);
	}
	
	@Test
	public void testValidateCorrectEmail(){
		testUser.setEmailAddress(VALID_EMAIL_ADDRESS);
		userEmailValidator.validate(testUser);
	}
	
	@Test(expected=InvalidUserDataException.class)
	public void testValidateWrongEmail(){
		testUser.setEmailAddress(INVALID_EMAIL_ADDRESS);
		userEmailValidator.validate(testUser);
	}
}
