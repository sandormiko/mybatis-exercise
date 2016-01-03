package mybatis.exercise.business.service.facade.api;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis.exercise.business.service.api.DailyStatisticService;
import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.DailyStatistic;
import mybatis.exercise.persistence.mapper.test.PersistenceBaseTest;
import mybatis.exercise.persistence.util.AppConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:business-context.xml" })
public class CampaignServiceFacadeTest extends PersistenceBaseTest {

	private static final int THRESHOLD = 1000;
	
	@Autowired
	private CampaignServiceFacade facade;

	@Autowired
	private DailyStatisticService dsService = null;

	@Test
	public void testWholeCampaign() {
		CouponRegistration testData = prepareTestData();
		String couponCode = testData.getCouponCode();
		for (int i = 0; i < THRESHOLD; i++) {
			testData.setCouponCode(couponCode + i);
			facade.registerCoupon(testData);
			int winningRate = testData.getTerritory().getVinningRate();
			boolean winner = (i + 1) % winningRate == 0;
			Assert.assertEquals(testData.getWinner(), winner ? AppConstants.YES : AppConstants.NO);
		}
		String statDay = LocalDate.now().toString(AppConstants.STATISTIC_DAY_PATTERN);
		DailyStatistic ds = dsService.findDailyStatistic(statDay);
		Assert.assertEquals(THRESHOLD, (int) ds.getDailyCount());
	}
}
