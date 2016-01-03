package mybatis.exercise.business.service.impl;

import java.util.Date;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.service.api.CouponRegistrationService;
import mybatis.exercise.business.service.api.WinnerDeciderService;
import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.mapper.CouponRegistrationMapper;
import mybatis.exercise.persistence.util.AppConstants;

@Service
public class CouponRegistrationServiceImpl implements CouponRegistrationService {

	private CouponRegistrationMapper couponRegMapper;
	private Validator<String> couponCodeValidator;
	private WinnerDeciderService winnerDeciderService;
	
	@Autowired
	public CouponRegistrationServiceImpl(CouponRegistrationMapper aCouponRegMapper,
			@Qualifier(value = "couponCodeValidator") Validator<String> aCouponCodeValidator,
			WinnerDeciderService aWinnerDeciderService) {
		this.couponRegMapper = aCouponRegMapper;
		this.couponCodeValidator = aCouponCodeValidator;
		this.winnerDeciderService = aWinnerDeciderService;
	}

	@Transactional
	public CouponRegistration registerCoupon(CouponRegistration couponReg) {
		validateCouponRegistration(couponReg.getCouponCode());
		setBusinessFields(couponReg);
		couponRegMapper.insertCouponRegistration(couponReg);
		setIsWinner(couponReg);
		return couponReg;
	}

	private void setBusinessFields(CouponRegistration couponReg) {
		Date submissionDate = LocalDate.now().toDate();
		couponReg.setSubmissionTs(submissionDate);
		couponReg.setWinner(AppConstants.NO);
	}

	private void validateCouponRegistration(String couponCode) {
		couponCodeValidator.validate(couponCode);
		CouponRegistration couponReqWithSameCode = couponRegMapper.findByCouponCode(couponCode);
		if (couponReqWithSameCode != null) {
			throw new InvalidCouponCodeException("Coupon code is already registered");
		}
	}
	
	@Override
	@Transactional
	public void updateCoupon(CouponRegistration coupunReg) {
		couponRegMapper.updateCouponRegistration(coupunReg);
	}
	
	public void setIsWinner(CouponRegistration couponReg) {
		boolean isWinner = winnerDeciderService.isWinnerCouponSubmission(couponReg);
		if(isWinner){
			couponReg.setWinner(AppConstants.YES);
			couponRegMapper.updateCouponRegistration(couponReg);
		}
	}


}
