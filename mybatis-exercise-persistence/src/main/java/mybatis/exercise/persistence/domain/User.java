package mybatis.exercise.persistence.domain;

import java.util.Date;

public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Date birthDate;
	
	public  User(){
		
	}
	public User(String aFirstName, String aLastName, String anEmailAddress,Date aBirthDate){
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.emailAddress = anEmailAddress;
		this.birthDate = aBirthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Integer getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ "birthDate=" + birthDate+"]";
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
