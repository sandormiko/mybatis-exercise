package mybatis.exercise.persistence.mapper.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.mapper.CouponRegistrationMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
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
