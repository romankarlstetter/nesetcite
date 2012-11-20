package fr.ecp.innovationprj.nesetcite.offers;

import java.util.Date;

import fr.ecp.innovationprj.nesetcite.Enterprise;


public class Offer {
	private String title;
	private String descriptionShort;
	private String descriptionLong;
	private Enterprise enterprise;
	private String domain;
	private String type;
	private Date offerDate;
	private Date possibleBeginDate;
	public Offer(String title, String descriptionShort, Enterprise enterprise) {
		this.title = title;
		this.descriptionShort = descriptionShort;
		this.descriptionLong = descriptionShort + "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren.";
		this.enterprise = enterprise;
		this.offerDate = new Date();
		this.possibleBeginDate = new Date(); 
		this.possibleBeginDate.setDate(possibleBeginDate.getDate()+5);
		this.type = "example type";
		this.domain = "example domain";
		System.out.println(possibleBeginDate + " - " + offerDate);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriptionShort() {
		return descriptionShort;
	}
	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String desctiptionLong) {
		this.descriptionLong = desctiptionLong;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	public Date getPossibleBeginDate() {
		return possibleBeginDate;
	}
	public void setPossibleBeginDate(Date possibleBeginDate) {
		this.possibleBeginDate = possibleBeginDate;
	}
}
