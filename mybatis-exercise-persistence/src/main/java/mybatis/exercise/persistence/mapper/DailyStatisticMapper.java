package mybatis.exercise.persistence.mapper;

import java.util.HashMap;

import mybatis.exercise.persistence.domain.DailyStatistic;

public interface DailyStatisticMapper {

	public DailyStatistic findDailyStatisticByStatisticDay(String statisticDay);
	public void insertDailyStatistic(DailyStatistic dailyStat);
	public Integer updateDailyStatistic(HashMap params);
}
