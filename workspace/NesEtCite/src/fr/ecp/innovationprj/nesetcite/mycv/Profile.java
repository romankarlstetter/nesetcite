package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile {
	private String firstName;
	private String lastName;
	private Date birthday;
	private String birthplace;
	private String telephoneNumber;
	private List<CVItem> cvItems;

	public Profile() {
		firstName = "";
		lastName = "";
		birthday = new Date();
		telephoneNumber = "+33 6...";
		cvItems = new ArrayList<CVItem>();
	}

	public String getBirthplace() {
		return birthplace;
	}
	
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public boolean addCVItem(CVItem object) {
		return cvItems.add(object);
	}
	
	public void setCvItems(List<CVItem> items){
		cvItems = items;
	}
	
	public List<CVItem> getCvItems(){
		return cvItems;
	}

	public CVItem removeCVItem(int location) {
		return cvItems.remove(location);
	}

	public int cvItemCount() {
		return cvItems.size();
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
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String number) {
		this.telephoneNumber = number;
	}
}
