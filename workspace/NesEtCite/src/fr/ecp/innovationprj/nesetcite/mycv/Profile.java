package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profile {
	private String firstName;
	private String lastName;
	private Date birthday;
	private String telephoneNumber;
	private List<CVItem> cvItems;

	public Profile() {
		firstName = "";
		lastName = "";
		birthday = new Date();
		telephoneNumber = "+33 6...";
		cvItems = new ArrayList<CVItem>();
	}

	public boolean addCVItem(CVItem object) {
		return cvItems.add(object);
	}
	
	public void setCVItems(List<CVItem> items){
		cvItems = items;
	}

	public CVItem getCVItem(int location) {
		return cvItems.get(location);
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
