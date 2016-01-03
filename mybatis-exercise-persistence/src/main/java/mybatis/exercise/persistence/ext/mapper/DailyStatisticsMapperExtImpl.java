package mybatis.exercise.persistence.ext.mapper;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.exercise.persistence.domain.DailyStatistic;
import mybatis.exercise.persistence.mapper.DailyStatisticMapper;

@Repository
public class DailyStatisticsMapperExtImpl implements  DailyStatisticsMapperExt{

	private DailyStatisticMapper statMapper;
	
	@Autowired
	public DailyStatisticsMapperExtImpl(DailyStatisticMapper dailyStatMapper) {
		statMapper = dailyStatMapper;
	}
	
	@Override
	public DailyStatistic insertDailyStatistic(DailyStatistic dailyStat) {
		final int version = 0;
		final int dailyCount = 1;
		dailyStat.setVersion(version);
		dailyStat.setDailyCount(dailyCount);
		statMapper.insertDailyStatistic(dailyStat);
		return dailyStat;
	}

	@Override
	public DailyStatistic updateDailyStatistic(DailyStatistic dailyStat) {
		Integer oldVersion = dailyStat.getVersion();
		Integer oldDailyCount = dailyStat.getDailyCount();
		dailyStat.setVersion(oldVersion+1);
		dailyStat.setDailyCount(oldDailyCount+1);
		HashMap<Object, Object> params = new HashMap<>();
		params.put("version", oldVersion);
		params.put("dailyStat", dailyStat);
		Integer updateCount = statMapper.updateDailyStatistic(params);
		if(updateCount != 1){
			throw new IllegalStateException("Entity has been concurrently updated");
		}
		return dailyStat;
	}

	@Override
	public DailyStatistic findDailyStatistic(String statisticDay) {
		return statMapper.findDailyStatisticByStatisticDay(statisticDay);
	}

}
