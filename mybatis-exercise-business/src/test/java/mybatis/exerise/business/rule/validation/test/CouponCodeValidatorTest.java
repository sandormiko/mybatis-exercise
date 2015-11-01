package mybatis.exerise.business.rule.validation.test;

import mybatis.exercise.business.exception.InvalidCouponCodeException;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.rule.validation.impl.CouponCodeValidator;

import org.junit.BeforeClass;
import org.junit.Test;

public class CouponCodeValidatorTest {

	private static Validator<String> couponCodeValidator;
	private static final String VALID_COUPON_CODE = "1234567890AA";
	private static final String INVALID_COUPON_CODE = "1234567";
	
	@BeforeClass
	public static void init(){
		couponCodeValidator = new CouponCodeValidator();
	}
	
	@Test(expected=InvalidCouponCodeException.class)
	public void testInvalidCouponCode(){
		couponCodeValidator.validate(INVALID_COUPON_CODE);
	}
	
	@Test(expected=InvalidCouponCodeException.class)
	public void testNullCouponCode(){
		couponCodeValidator.validate(null);
	}
	
	@Test
	public void testValidCouponCode(){
		couponCodeValidator.validate(VALID_COUPON_CODE);
	}
}
