package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.Date;

public class CVItem {
	private String category;
	private String title;
	private String description;
	private Date dateStart;
	private Date dateEnd;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String toString(){
		return title  + "\n" + dateStart + " - " + dateEnd +"\n"+ description;
	}
}
