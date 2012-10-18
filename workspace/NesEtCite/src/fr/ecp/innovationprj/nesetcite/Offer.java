package fr.ecp.innovationprj.nesetcite;

import java.util.Date;


public class Offer {
	private String title;
	private String descriptionShort;
	private String desctiptionLong;
	private Enterprise enterprise;
	private String domain;
	private String type;
	private Date offerDate;
	private Date possibleBeginDate;
	public Offer(String title, String descriptionShort, Enterprise enterprise) {
		this.title = title;
		this.descriptionShort = descriptionShort;
		this.enterprise = enterprise;
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
	public String getDesctiptionLong() {
		return desctiptionLong;
	}
	public void setDesctiptionLong(String desctiptionLong) {
		this.desctiptionLong = desctiptionLong;
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
