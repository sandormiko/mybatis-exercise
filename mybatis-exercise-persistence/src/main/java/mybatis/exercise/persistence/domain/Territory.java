package mybatis.exercise.persistence.domain;

public class Territory {

	private Integer territoryId;
	private String countryName;
	private int nrOfBallsPerDay;
	private int nrOfBallsPerCampaign;
	private int vinningRate;
	
	public Integer getTerritoryId() {
		return territoryId;
	}
	
	public void setTerritoryId(Integer territoryId) {
		this.territoryId = territoryId;;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getNrOfBallsPerDay() {
		return nrOfBallsPerDay;
	}

	public void setNrOfBallsPerDay(int nrOfBallsPerDay) {
		this.nrOfBallsPerDay = nrOfBallsPerDay;
	}

	public int getNrOfBallsPerCampaign() {
		return nrOfBallsPerCampaign;
	}

	public void setNrOfBallsPerCampaign(int nrOfBallsPerCampaign) {
		this.nrOfBallsPerCampaign = nrOfBallsPerCampaign;
	}

	public int getVinningRate() {
		return vinningRate;
	}

	public void setVinningRate(int vinningRate) {
		this.vinningRate = vinningRate;
	}


	@Override
	public String toString() {
		return "Territory [territoryId=" + territoryId + ", countryName="
				+ countryName + ", nrOfBallsPerDay=" + nrOfBallsPerDay
				+ ", nrOfBallsPerCampaign=" + nrOfBallsPerCampaign
				+ ", vinningRate=" + vinningRate + "]";
	}

}
