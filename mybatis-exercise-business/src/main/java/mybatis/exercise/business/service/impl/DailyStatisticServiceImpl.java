package mybatis.exercise.business.service.impl;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.business.service.api.DailyStatisticService;
import mybatis.exercise.persistence.domain.DailyStatistic;
import mybatis.exercise.persistence.ext.mapper.DailyStatisticsMapperExt;
import mybatis.exercise.persistence.util.AppConstants;

@Service
@Transactional
public class DailyStatisticServiceImpl implements DailyStatisticService {

	private DailyStatisticsMapperExt dailyStatMapper = null;

	@Autowired
	public DailyStatisticServiceImpl(DailyStatisticsMapperExt aDailyStatMapper) {
		this.dailyStatMapper = aDailyStatMapper;
	}

	@Override
	public DailyStatistic insertOrUpdateDailyStatistic() {
		DailyStatistic result = null;
		String statisticDay = LocalDate.now().toString(AppConstants.STATISTIC_DAY_PATTERN);
		DailyStatistic dailyStat = dailyStatMapper.findDailyStatistic(statisticDay);
		if (dailyStat == null) {
			dailyStat = new DailyStatistic();
			dailyStat.setStatisticDay(statisticDay);
			result = dailyStatMapper.insertDailyStatistic(dailyStat);
		} else {
			result = dailyStatMapper.updateDailyStatistic(dailyStat);
		}
		return result;
	}

	@Override
	public DailyStatistic findDailyStatistic(String statisticDay) {
		return dailyStatMapper.findDailyStatistic(statisticDay);
	}

}
