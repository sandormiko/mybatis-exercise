package mybatis.exercise.persistence.domain;

public class DailyStatistic {

	private Integer dailyStatisticId;
	private String statisticDay;
	private Integer dailyCount;
	private Integer version;
	
	public Integer getDailyStatisticId() {
		return dailyStatisticId;
	}
	public String getStatisticDay() {
		return statisticDay;
	}
	public Integer getDailyCount() {
		return dailyCount;
	}
	public Integer getVersion() {
		return version;
	}
	@Override
	public String toString() {
		return "DailyStatistic [dailyStatisticId=" + dailyStatisticId + ", statisticDay=" + statisticDay
				+ ", dailyCount=" + dailyCount + ", version=" + version + "]";
	}
	public void setStatisticDay(String statisticDay) {
		this.statisticDay = statisticDay;
	}
	public void setDailyCount(Integer dailyCount) {
		this.dailyCount = dailyCount;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
