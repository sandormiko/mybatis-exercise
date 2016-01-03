package mybatis.exercise.persistence.mapper.test;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.persistence.domain.DailyStatistic;
import mybatis.exercise.persistence.ext.mapper.DailyStatisticsMapperExt;
import mybatis.exercise.persistence.util.AppConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DailyStatisticMapperTest {

	@Autowired
	private DailyStatisticsMapperExt statMapper;

	@Test
	public void testInsertDailyStatistics() {
		DailyStatistic dailyStat = prepareDailyStatistic();
		statMapper.insertDailyStatistic(dailyStat);
		Assert.assertNotNull(dailyStat.getDailyStatisticId());
	}

	@Test
	public void testUpdateDailyStatistics() {
		DailyStatistic dailyStat = prepareDailyStatistic();
		statMapper.insertDailyStatistic(dailyStat);
		statMapper.updateDailyStatistic(dailyStat);
		Assert.assertEquals(2, (int) dailyStat.getDailyCount());
	}

	private DailyStatistic prepareDailyStatistic() {
		DailyStatistic dailyStat = new DailyStatistic();
		dailyStat.setStatisticDay(LocalDate.now().toString(AppConstants.STATISTIC_DAY_PATTERN));
		return dailyStat;
	}

	@Test
	public void testFindDailyStatistics() {
		DailyStatistic dailyStat = prepareDailyStatistic();
		statMapper.insertDailyStatistic(dailyStat);
		dailyStat = statMapper.findDailyStatistic(dailyStat.getStatisticDay());
		Assert.assertNotNull(dailyStat);
	}

	@Test(expected = IllegalStateException.class)
	public void testConsurrentUpdateException() {
		DailyStatistic dailyStat = prepareDailyStatistic();
		statMapper.insertDailyStatistic(dailyStat);
		dailyStat.setVersion(3);
		statMapper.updateDailyStatistic(dailyStat);
	}
}
