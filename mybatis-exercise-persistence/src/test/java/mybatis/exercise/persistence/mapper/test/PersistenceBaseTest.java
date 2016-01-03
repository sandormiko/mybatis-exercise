package mybatis.exercise.persistence.mapper.test;

import org.joda.time.LocalDate;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.domain.User;

public abstract class PersistenceBaseTest {

	protected static final int ID_HUNGARY = 1000;
	protected static final int ID_TEST_USER = 1000;
	protected static final String TEST_COUPON_CODE = "12345678901po";
	private static final int TEST_WINNING_RATE = 80;
	protected static final String TEST_EMAIL_TO_SEARCH_FOR = "jakab@gipsz.hu";
	protected static final String TEST_EMAIL = "test@gipsz.hu";
	private static final String TEST_FIRSTNAME = "Jakab";
	private static final String TEST_LASTNAME = "Gipsz";
	
	protected CouponRegistration prepareTestData() {
		CouponRegistration couponRegistration = new CouponRegistration();
		User submittedBy = prepareTestUser();
		couponRegistration.setUser(submittedBy);
		Territory territory = prepareTerritory();
		couponRegistration.setTerritory(territory);
		couponRegistration.setCouponCode(TEST_COUPON_CODE);
		couponRegistration.setSubmissionTs(LocalDate.now().toDate());
		return couponRegistration;
	}

	private Territory prepareTerritory() {
		Territory territory = new Territory();
		territory.setTerritoryId(ID_HUNGARY);
		territory.setVinningRate(TEST_WINNING_RATE);
		return territory;
	}

	protected User prepareTestUser() {
		User submittedBy = new User();
		submittedBy.setEmailAddress(TEST_EMAIL);
		submittedBy.setBirthDate(new LocalDate(1972, 01, 02).toDate());
		submittedBy.setUserId(1000);
		submittedBy.setFirstName(TEST_FIRSTNAME);
		submittedBy.setLastName(TEST_LASTNAME);
		return submittedBy;
	}

}
