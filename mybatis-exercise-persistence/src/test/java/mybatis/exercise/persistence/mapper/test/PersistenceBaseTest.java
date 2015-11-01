package mybatis.exercise.persistence.mapper.test;

import java.util.Date;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.domain.User;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml"})
public abstract class PersistenceBaseTest {

	protected static final int ID_HUNGARY = 1000;
	protected static final int ID_TEST_USER = 1000;
	protected  CouponRegistration testCouponRegistration;
	protected static final String TEST_COUPON_CODE= "12345678901po";
			
	protected void prepareTestData(){
		Territory territory = new Territory();
		territory.setTerritoryId(ID_HUNGARY);
		User user = new User();
		user.setUserId(ID_TEST_USER);
		prepareTestCouponRegistration(territory, user);
	}

	private  void prepareTestCouponRegistration(Territory territory,
			User user) {
		testCouponRegistration = new CouponRegistration();
		testCouponRegistration.setTerritory(territory);
		testCouponRegistration.setUser(user);
		testCouponRegistration.setCouponCode(TEST_COUPON_CODE);
		testCouponRegistration.setSubmissionTs(new Date());
	}
	
}
