package mybatis.exercise.business.service.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.business.service.api.CouponRegistrationService;
import mybatis.exercise.business.service.api.DailyStatisticService;
import mybatis.exercise.business.service.api.UserService;
import mybatis.exercise.business.service.facade.api.CampaignServiceFacade;
import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.User;

@Service
public class CampaignServiceFacadeImpl implements CampaignServiceFacade {

	private CouponRegistrationService couponRegistrationService;
	private UserService userService;
	private DailyStatisticService dailyStatService = null;

	@Autowired
	public CampaignServiceFacadeImpl(CouponRegistrationService aCouponRegistrationService, UserService aUserService,
			DailyStatisticService aStatService) {
		this.couponRegistrationService = aCouponRegistrationService;
		this.userService = aUserService;
		this.dailyStatService = aStatService;
	}

	@Transactional
	public void registerCoupon(CouponRegistration couponRegAttempt) {
		User submittedBy = couponRegAttempt.getUser();
		String email = submittedBy.getEmailAddress();
		User existingUser = userService.getUserByEmail(email);
		if (existingUser == null) {
			userService.insertUser(submittedBy);
		}
		couponRegistrationService.registerCoupon(couponRegAttempt);
		dailyStatService.insertOrUpdateDailyStatistic();
	}

}
