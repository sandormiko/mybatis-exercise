package mybatis.exercise.business.base;

import org.joda.time.LocalDate;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.domain.User;

public abstract class BusinessTestBase {

	protected CouponRegistration prepareTestData() {
		CouponRegistration couponRegistration = new CouponRegistration();
		User submittedBy = prepareUser();
		couponRegistration.setUser(submittedBy);
		Territory territory = prepareTerritory();
		couponRegistration.setTerritory(territory);
		couponRegistration.setCouponCode("AA123456789");
		return couponRegistration;
	}

	private Territory prepareTerritory() {
		Territory territory = new Territory();
		territory.setTerritoryId(1000);
		territory.setVinningRate(80);
		return territory;
	}

	private User prepareUser() {
		User submittedBy = new User();
		submittedBy.setEmailAddress("test@test.hu");
		submittedBy.setBirthDate(new LocalDate(1972, 01, 02).toDate());
		submittedBy.setUserId(1000);
		submittedBy.setFirstName("Jakab");
		submittedBy.setLastName("Gipsz");
		return submittedBy;
	}
}
