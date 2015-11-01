package mybatis.exercise.business.rule.validation.impl;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.exception.InvalidUserDataException;
import mybatis.exercise.business.rule.validation.api.Validator;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "userAgeValidator")
@Component
public class UserAgeValidator implements Validator<User>{

	private int MINIMUM_AGE = 13;
	
	@Override
	public void validate(User value) {
		LocalDate dateOfBorn = new LocalDate (value.getBirthDate());
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(dateOfBorn, now);
		if(age.getYears() < MINIMUM_AGE){
			String errorMsg = String.format("Under %s it is not allowed to participate in the campaign.",MINIMUM_AGE);
			throw new InvalidUserDataException(errorMsg);
		}	
	}

}
