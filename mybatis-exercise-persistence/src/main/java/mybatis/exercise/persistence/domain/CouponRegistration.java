package mybatis.exercise.persistence.domain;

import java.util.Date;

public class CouponRegistration {

	private Integer registrationId;
	private String couponCode;
	private User user; 
	private Territory territory;
	private String winner;
	private Date submissionTs;
	private Integer version;
	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	
	public String getWinner(){
		return winner;
	}
	
	public void setWinner(String winner){
		this.winner = winner;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public void setSubmissionTs(Date aSubmissionTs){
		this.submissionTs = aSubmissionTs;
	}
	
	public Date getSubmissionTs(){
		return submissionTs;
	}

	@Override
	public String toString() {
		return "CouponRegistration [registrationId=" + registrationId
				+ ", couponCode=" + couponCode + ", user=" + user
				+ ", territory=" + territory + ", winner=" + winner
				+ ", submissionTs=" + submissionTs + "]";
	}

	public Integer getVersion() {
		return version;
	}
	
}
