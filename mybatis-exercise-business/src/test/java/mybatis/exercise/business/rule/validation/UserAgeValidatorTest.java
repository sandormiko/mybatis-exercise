package mybatis.exercise.business.rule.validation;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.rule.validation.impl.UserAgeValidator;
import mybatis.exercise.persistence.domain.User;

public class UserAgeValidatorTest {

	private Validator<User> userAgeValidator;

	@Before
	public void init() {
		userAgeValidator = new UserAgeValidator();
	}

	@Test
	public void testValidBirthDate() {
		Date validBirthDate = new LocalDate(1981, 11, 12).toDate();
		User testUser = new User();
		testUser.setBirthDate(validBirthDate);
		userAgeValidator.validate(testUser);
	}

	@Test(expected = InvalidUserDataException.class)
	public void testInvalidBirthDate() {
		Date invalidBirthDate = new LocalDate(2005, 11, 12).toDate();
		User testUser = new User();
		testUser.setBirthDate(invalidBirthDate);
		userAgeValidator.validate(testUser);
	}
}
