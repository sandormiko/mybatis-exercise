package mybatis.exercise.business.service.api;

import mybatis.exercise.persistence.domain.CouponRegistration;

public interface CouponRegistrationService {

	public CouponRegistration registerCoupon(CouponRegistration coupunReg);
	public void updateCoupon(CouponRegistration couponReg);
}
