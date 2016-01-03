package mybatis.exercise.persistence.ext.mapper;

import mybatis.exercise.persistence.domain.DailyStatistic;

public interface DailyStatisticsMapperExt {

	public DailyStatistic insertDailyStatistic(DailyStatistic dailyStat);
	public DailyStatistic updateDailyStatistic(DailyStatistic dailyStat);
	public DailyStatistic findDailyStatistic(String statisticDay);
}
