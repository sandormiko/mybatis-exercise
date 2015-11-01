package mybatis.exercise.business.service.impl;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.mapper.CouponRegistrationMapper;
import mybatis.exercise.business.constants.BusinessConsts;
import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.service.api.CouponRegistrationService;
import mybatis.exercise.business.service.api.WinnerDeciderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CouponRegistrationServiceImpl implements CouponRegistrationService {

	private CouponRegistrationMapper couponRegMapper;
	private Validator<String> couponCodeValidator;
	private WinnerDeciderService winnerDeciderService;
	
	@Autowired
	public CouponRegistrationServiceImpl(
			CouponRegistrationMapper aCouponRegMapper,
			@Qualifier(value = "couponCodeValidator") Validator<String> aCouponCodeValidator,
			WinnerDeciderService aWinnerDeciderService) {
		this.couponRegMapper = aCouponRegMapper;
		this.couponCodeValidator = aCouponCodeValidator;
		this.winnerDeciderService = aWinnerDeciderService;
	}
	
	@Transactional
	public void registerCoupon(CouponRegistration couponReg) {
		validateCouponRegistration(couponReg.getCouponCode());
		couponReg.setSubmissionTs(new Date());
		boolean isWinner = winnerDeciderService.isWinnerCouponSubmission(couponReg);
		couponReg.setWinner(isWinner ? BusinessConsts.YES : BusinessConsts.NO);
		couponRegMapper.insertCouponRegistration(couponReg);
	}

	private void validateCouponRegistration(String couponCode) {
		couponCodeValidator.validate(couponCode);
		CouponRegistration couponReqWithSameCode = couponRegMapper.getCouponRegistrationByCouponCode(couponCode);
		if(couponReqWithSameCode != null){
			throw new InvalidCouponCodeException("Coupon code is already registered");
		}
	}
}
