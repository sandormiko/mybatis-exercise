package mybatis.exercise.business.service.api;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.mapper.CouponRegistrationCountMapper;
import mybatis.exercise.persistence.mapper.TerritoryMapper;
import mybatis.exercise.business.service.api.WinnerDeciderService;
import mybatis.exercise.business.service.impl.WinnerDeciderServiceImpl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WinnerDeciderServiceTest {

	private static CouponRegistration couponRegistration;
	
	@BeforeClass
	public static void init(){
		Territory territory = new Territory();
		couponRegistration = new CouponRegistration();
		couponRegistration.setTerritory(territory);
	}
	
	@Test
	public void testWinnerCouponSubmission(){
		int vinningRate = 80;
		int nrTotalSubmissions = 159;
		WinnerDeciderService deciderService = prepareDeciderService(vinningRate, nrTotalSubmissions);
		boolean isWinner = deciderService.isWinnerCouponSubmission(couponRegistration);
		Assert.assertTrue("This is a winner submission",isWinner);
	}
	
	@Test
	public void testNotWinnerCouponSubmission(){
		int vinningRate = 80;
		int nrTotalSubmissions = 161;
		WinnerDeciderService deciderService = prepareDeciderService(vinningRate, nrTotalSubmissions);
		boolean isWinner = deciderService.isWinnerCouponSubmission(couponRegistration);
		Assert.assertFalse("This is not a winner submission",isWinner);
	}
	
	public WinnerDeciderService prepareDeciderService(int vinningRate, int nrTotalSubmissions){
		TerritoryMapper mockTerritoryMapper = getMockTerritoryMapper(vinningRate);
		CouponRegistrationCountMapper mockRegCountMapper = getMockCouponRegistrationCountMapper(nrTotalSubmissions);
		return new WinnerDeciderServiceImpl(mockTerritoryMapper, mockRegCountMapper);
	};
	
	private static TerritoryMapper getMockTerritoryMapper(final int vinningRate){
		TerritoryMapper mockMapper = new TerritoryMapper() {
			@Override
			public Territory getTerritoryById(Integer territoryId) {
				Territory testTerritory = new Territory();
				testTerritory.setVinningRate(vinningRate);
				return testTerritory;
			}
		};
		return mockMapper;
	}
	
	private static CouponRegistrationCountMapper getMockCouponRegistrationCountMapper(final int nrSubmittedCoupons){
		CouponRegistrationCountMapper mockMapper = new CouponRegistrationCountMapper(){
			@Override
			public Integer getRegistrationCountByTerritory(
					CouponRegistration registration) {
				return nrSubmittedCoupons;
			}
		};
		return mockMapper;
	}
}
