package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile {
	private String firstName;
	private String lastName;
	private Date birthday;
	private String telephone_number;
	private List<String> education;
	private List<String> professional_experiences;
	private List<String> activities;

	public Profile() {
		firstName = "";
		lastName = "";
		birthday = new Date();
		telephone_number = "+33 6...";
		education = new ArrayList<String>();
		professional_experiences = new ArrayList<String>();
		activities = new ArrayList<String>();
	}
	
	public List<String> getEducation() {
		return education;
	}
	public void setEducation(List<String> education) {
		this.education = education;
	}
	public List<String> getProfessional_experiences() {
		return professional_experiences;
	}
	public void setProfessional_experiences(List<String> professional_experiences) {
		this.professional_experiences = professional_experiences;
	}
	public List<String> getActivities() {
		return activities;
	}
	public void setActivities(List<String> activities) {
		this.activities = activities;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
}
