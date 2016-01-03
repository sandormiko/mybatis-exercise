package mybatis.exercise.business.service.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.business.base.BusinessTestBase;
import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.persistence.domain.CouponRegistration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:business-context.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CouponRegistrationServiceTest extends BusinessTestBase{

	@Autowired
	private CouponRegistrationService couponRegService;

	@Test
	public void testCouponRegistration() {
		CouponRegistration testData = prepareTestData();
		couponRegService.registerCoupon(testData);
		Assert.assertNotNull(testData.getRegistrationId());
	}

	@Test(expected = InvalidCouponCodeException.class)
	public void testSameCouponRegistration() {
		CouponRegistration testData = prepareTestData();
		couponRegService.registerCoupon(testData);
		couponRegService.registerCoupon(testData);
	}
}
