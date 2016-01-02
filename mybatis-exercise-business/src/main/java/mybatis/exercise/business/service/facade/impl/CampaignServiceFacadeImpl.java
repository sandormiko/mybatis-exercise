package mybatis.exercise.business.service.facade.impl;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.business.constants.BusinessConsts;
import mybatis.exercise.business.service.api.CouponRegistrationService;
import mybatis.exercise.business.service.api.UserService;
import mybatis.exercise.business.service.api.WinnerDeciderService;
import mybatis.exercise.business.service.facade.api.CampaignServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampaignServiceFacadeImpl implements CampaignServiceFacade {

	private CouponRegistrationService couponRegistrationService;
	private UserService userService;
	private WinnerDeciderService winnerDeciderService;
	
	@Autowired
	public CampaignServiceFacadeImpl(
			CouponRegistrationService aCouponRegistrationService,
			UserService aUserService,WinnerDeciderService aWinnerDeciderService) {
		this.couponRegistrationService = aCouponRegistrationService;
		this.userService = aUserService;
		this.winnerDeciderService = aWinnerDeciderService;
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
	}

	@Override
	public void setIsWinner(CouponRegistration couponReg) {
		boolean isWinner = winnerDeciderService.isWinnerCouponSubmission(couponReg);
		couponReg.setWinner(isWinner ? BusinessConsts.YES : BusinessConsts.NO);
		couponRegistrationService.updateCoupon(couponReg);
	}

}
