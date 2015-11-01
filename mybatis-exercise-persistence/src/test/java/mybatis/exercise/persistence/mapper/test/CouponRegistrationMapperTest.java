package mybatis.exercise.persistence.mapper.test;

import mybatis.exercise.persistence.mapper.CouponRegistrationMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponRegistrationMapperTest extends PersistenceBaseTest{

	@Autowired
	private CouponRegistrationMapper couponRegMapper;

	@Before
	public void init(){
		prepareTestData();
	}
	
	@Test
	public void testInsertCouponRegistration(){
		couponRegMapper.insertCouponRegistration(testCouponRegistration);
		Assert.assertNotNull(testCouponRegistration.getRegistrationId());
	}
	
}
