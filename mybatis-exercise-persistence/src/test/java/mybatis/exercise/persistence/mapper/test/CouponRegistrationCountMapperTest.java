package mybatis.exercise.persistence.mapper.test;

import mybatis.exercise.persistence.mapper.CouponRegistrationCountMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponRegistrationCountMapperTest extends PersistenceBaseTest{

	@Autowired
	private CouponRegistrationCountMapper couponRegCountMapper;
	
	@Before
	public  void init(){
		 prepareTestData();
	}
	
	@Test
	public void testBetRegistrationCountByTerritory(){
		Integer total = couponRegCountMapper.getRegistrationCountByTerritory(testCouponRegistration);
		Assert.assertEquals((int)2, total.intValue());
	}
}
