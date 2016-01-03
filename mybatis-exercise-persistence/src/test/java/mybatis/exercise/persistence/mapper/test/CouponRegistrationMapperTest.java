package mybatis.exercise.persistence.mapper.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.mapper.CouponRegistrationMapper;

public class CouponRegistrationMapperTest extends PersistenceBaseTest{

	@Autowired
	private CouponRegistrationMapper couponRegMapper;

	@Test
	public void testInsertCouponRegistration(){
		CouponRegistration testData = prepareTestData();
		couponRegMapper.insertCouponRegistration(testData);
		Assert.assertNotNull(testData.getRegistrationId());
	}
	
}
