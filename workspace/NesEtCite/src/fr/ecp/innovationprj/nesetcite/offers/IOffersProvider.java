package fr.ecp.innovationprj.nesetcite.offers;

import java.util.List;


public interface IOffersProvider {
	List<Offer> getOffers();
	void setFilter(String filter);
}
