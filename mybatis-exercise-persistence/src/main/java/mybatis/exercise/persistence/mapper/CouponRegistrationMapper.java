package mybatis.exercise.persistence.mapper;

import mybatis.exercise.persistence.domain.CouponRegistration;

public interface CouponRegistrationMapper{

	public Integer insertCouponRegistration(CouponRegistration copunReg);
	public CouponRegistration getCouponRegistrationByCouponCode(String couponCode);
}
