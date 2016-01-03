package mybatis.exercise.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.exercise.business.service.api.WinnerDeciderService;
import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.mapper.CouponRegistrationCountMapper;

@Service
public class WinnerDeciderServiceImpl implements WinnerDeciderService {

	private CouponRegistrationCountMapper couponRegCountMapper;

	@Autowired
	public WinnerDeciderServiceImpl(CouponRegistrationCountMapper aCouponRegCountMapper) {
		this.couponRegCountMapper = aCouponRegCountMapper;
	}

	@Override
	public boolean isWinnerCouponSubmission(CouponRegistration couponRegistration) {
		Territory submittedTerritory = couponRegistration.getTerritory();
		Integer nrOfSubmissionsInTerritory = couponRegCountMapper.getRegistrationCountByTerritory(couponRegistration);
		int vinningRate = submittedTerritory.getVinningRate();
		boolean isWinner = calculateIsWinner(vinningRate, nrOfSubmissionsInTerritory);
		return isWinner;
	}

	private boolean calculateIsWinner(int vinningRate, int nrOfSubmissionsInTerritory) {
		return ((nrOfSubmissionsInTerritory % vinningRate) == 0);
	}
}
