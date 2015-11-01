package mybatis.exercise.business.service.api;

import mybatis.exercise.persistence.domain.CouponRegistration;


public interface WinnerDeciderService {

	public boolean isWinnerCouponSubmission(CouponRegistration couponRegistration);
}
