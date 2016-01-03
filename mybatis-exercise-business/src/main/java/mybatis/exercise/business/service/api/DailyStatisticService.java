package mybatis.exercise.business.service.api;

import mybatis.exercise.persistence.domain.DailyStatistic;

public interface DailyStatisticService {

	public DailyStatistic insertOrUpdateDailyStatistic();
	public DailyStatistic findDailyStatistic(String statisticDay);
}
