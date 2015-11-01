package mybatis.exerise.business.rule.validation.test;

import mybatis.exercise.persistence.domain.User;

import java.util.Date;

import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.rule.validation.impl.UserAgeValidator;

import org.joda.time.LocalDate;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserAgeValidatorTest {

	private static Validator<User> userAgeValidator;
	private static User testUser = null;
	private static Date validBirthDate = null;
	private static Date invalidBirthDate = null;
	
	@BeforeClass
	public static void init(){
		testUser = new User();
		userAgeValidator = new UserAgeValidator();
		validBirthDate = new LocalDate(1981,11,12).toDate();
		invalidBirthDate = new LocalDate(2005,11,12).toDate();
	}
	
	@Test
	public void testValidBirthDate(){
		testUser.setBirthDate(validBirthDate);
		userAgeValidator.validate(testUser);
	}
	
	@Test(expected=InvalidUserDataException.class)
	public void testInvalidBirthDate(){
		testUser.setBirthDate(invalidBirthDate);
		userAgeValidator.validate(testUser);
	}
}
