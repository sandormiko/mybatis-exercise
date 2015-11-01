package mybatis.exercise.business.service.impl;

import mybatis.exercise.persistence.domain.CouponRegistration;
import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.mapper.CouponRegistrationCountMapper;
import mybatis.exercise.persistence.mapper.TerritoryMapper;
import mybatis.exercise.business.service.api.WinnerDeciderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinnerDeciderServiceImpl implements WinnerDeciderService{

	private TerritoryMapper territoryMapper;
	private CouponRegistrationCountMapper couponRegCountMapper;
	
	@Autowired
	public WinnerDeciderServiceImpl(TerritoryMapper aTerritoryMapper,
			CouponRegistrationCountMapper aCouponRegCountMapper) {
		this.territoryMapper = aTerritoryMapper;
		this.couponRegCountMapper = aCouponRegCountMapper;
	}

	@Override
	public boolean isWinnerCouponSubmission(CouponRegistration couponRegistration) {
		Integer territoryId = couponRegistration.getTerritory().getTerritoryId();
		Territory submittedTerritory = territoryMapper.getTerritoryById(territoryId);
		Integer nrOfSubmissionsInTerritory = couponRegCountMapper.getRegistrationCountByTerritory(couponRegistration);
		int vinningRate = submittedTerritory.getVinningRate();
		boolean isWinner = calculateIsWinner(vinningRate, nrOfSubmissionsInTerritory);
		return isWinner;
	}

	private boolean calculateIsWinner(int vinningRate, int nrOfSubmissionsInTerritory){
		int nextNrOfSubmissionInTerritory = nrOfSubmissionsInTerritory +1;
		return ((nextNrOfSubmissionInTerritory % vinningRate) == 0);
	}
}
