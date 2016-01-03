package mybatis.exercise.business.service.api;

import org.junit.Assert;
import org.junit.Test;

import mybatis.exercise.business.base.BusinessTestBase;
import mybatis.exercise.business.service.impl.WinnerDeciderServiceImpl;
import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.mapper.CouponRegistrationCountMapper;

public class WinnerDeciderServiceTest extends BusinessTestBase{

	@Test
	public void testWinnerCouponSubmission() {
		int vinningRate = 80;
		int nrTotalSubmissions = 160;
		WinnerDeciderService deciderService = prepareDeciderService(vinningRate, nrTotalSubmissions);
		boolean isWinner = deciderService.isWinnerCouponSubmission(prepareTestData());
		Assert.assertTrue("This is a winner submission", isWinner);
	}

	@Test
	public void testNotWinnerCouponSubmission() {
		int vinningRate = 80;
		int nrTotalSubmissions = 161;
		WinnerDeciderService deciderService = prepareDeciderService(vinningRate, nrTotalSubmissions);
		boolean isWinner = deciderService.isWinnerCouponSubmission(prepareTestData());
		Assert.assertFalse("This is not a winner submission", isWinner);
	}

	public WinnerDeciderService prepareDeciderService(int vinningRate, int nrTotalSubmissions) {
		CouponRegistrationCountMapper mockRegCountMapper = getMockCouponRegistrationCountMapper(nrTotalSubmissions);
		return new WinnerDeciderServiceImpl(mockRegCountMapper);
	};

	private static CouponRegistrationCountMapper getMockCouponRegistrationCountMapper(final int nrSubmittedCoupons) {
		CouponRegistrationCountMapper mockMapper = new CouponRegistrationCountMapper() {
			@Override
			public Integer getRegistrationCountByTerritory(CouponRegistration registration) {
				return nrSubmittedCoupons;
			}
		};
		return mockMapper;
	}
}
