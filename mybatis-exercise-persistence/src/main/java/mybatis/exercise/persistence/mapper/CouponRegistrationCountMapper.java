package mybatis.exercise.persistence.mapper;

import mybatis.exercise.persistence.domain.CouponRegistration;

public interface CouponRegistrationCountMapper {

	public Integer getRegistrationCountByTerritory(CouponRegistration registration);	
}
