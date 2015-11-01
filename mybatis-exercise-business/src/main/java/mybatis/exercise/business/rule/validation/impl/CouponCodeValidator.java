package mybatis.exercise.business.rule.validation.impl;

import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.business.rule.validation.api.Validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier(value = "couponCodeValidator")
@Component
public class CouponCodeValidator implements Validator<String> {

	private int COUPON_MIN_LENGTH = 10;
	
	@Override
	public void validate(String couponCode) {
		validateCouponLength(couponCode);
	}

	private void validateCouponLength(String couponCode) {
		if(StringUtils.length(couponCode)< COUPON_MIN_LENGTH){
			String errorMsg = String.format("Coupon code is shorten than %d chars", COUPON_MIN_LENGTH);
			throw new InvalidCouponCodeException(errorMsg);
		}
	}

}
