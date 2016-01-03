package mybatis.exercise.business.service.facade.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis.exercise.business.base.BusinessTestBase;
import mybatis.exercise.business.constants.BusinessConsts;
import mybatis.exercise.persistence.domain.CouponRegistration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:business-context.xml" })
public class CampaignServiceFacadeTest extends BusinessTestBase{

	@Autowired
	private CampaignServiceFacade facade;
	
	@Test
	public void testWholeCampaign(){
		CouponRegistration testData = prepareTestData();
		String couponCode = testData.getCouponCode();
		for(int i=0;i<1000;i++){
			testData.setCouponCode(couponCode+i);
			facade.registerCoupon(testData);
			facade.setIsWinner(testData);
			int winningRate = testData.getTerritory().getVinningRate();
			boolean winner = (i+1)%winningRate ==0;
			Assert.assertEquals(testData.getWinner(), winner ? BusinessConsts.YES: BusinessConsts.NO);
		}
	}
}
