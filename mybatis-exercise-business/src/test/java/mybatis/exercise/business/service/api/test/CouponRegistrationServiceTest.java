package mybatis.exercise.business.service.api.test;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.business.service.api.CouponRegistrationService;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:business-context.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CouponRegistrationServiceTest {

	@Autowired
	private CouponRegistrationService couponRegService;
	private CouponRegistration couponRegistration;
	
	@Before
	public void init(){
		couponRegistration = new CouponRegistration();
		User submittedBy = prepareUser();
		couponRegistration.setUser(submittedBy);
		Territory territory = prepareTerritory();
		couponRegistration.setTerritory(territory);
		couponRegistration.setCouponCode("AA123456789");
	}

	private Territory prepareTerritory() {
		Territory territory = new Territory();
		territory.setTerritoryId(1000);
		return territory;
	}

	private User prepareUser() {
		User submittedBy = new User();
		submittedBy.setEmailAddress("test@test.hu");
		submittedBy.setBirthDate(new LocalDate(1972,01,02).toDate());
		submittedBy.setUserId(1000);
		return submittedBy;
	}
	
	@Test
	public void testCouponRegistration(){
		couponRegService.registerCoupon(couponRegistration);
		Assert.assertNotNull(couponRegistration.getRegistrationId());
	}
	
	@Test(expected=InvalidCouponCodeException.class)
	public void testSameCouponRegistration(){
		couponRegService.registerCoupon(couponRegistration);
		couponRegService.registerCoupon(couponRegistration);
	}
}
