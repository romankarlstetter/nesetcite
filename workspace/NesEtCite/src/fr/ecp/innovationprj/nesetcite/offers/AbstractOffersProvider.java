package fr.ecp.innovationprj.nesetcite.offers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class AbstractOffersProvider {
	protected OfferFilter filter;
	abstract List<Offer> getFilteredOfferList();
	void setFilter(OfferFilter filter){
		this.filter = filter;
	}
	
	// provide local filtering
	protected List<Offer> applyFilter(List<Offer> offers){
		List<Offer> filtered = new ArrayList<Offer>();
		//filtered.addAll(offers);
		Iterator<Offer> i= offers.iterator();
		while(i.hasNext()){
			Offer o = i.next();
			if(
					o.getDescriptionShort().contains(filter.getDescriptionFilter()) 
					|| o.getTitle().contains(filter.getTitleFilter())
			){
				filtered.add(o);
			}
		}
    	return filtered;
	}
	
	
	public static class OfferFilter {
		private String titleFilter = "";
		private String descriptionFilter = "";
		
		public OfferFilter(){
		}
		public OfferFilter(String title, String description) {
			this.titleFilter = title;
			this.descriptionFilter = description;
		}
		
		// TODO add other filter criteria when necessary
		public String getTitleFilter() {
			return titleFilter;
		}
		public void setTitleFilter(String titleFilter) {
			this.titleFilter = titleFilter;
		}
		public String getDescriptionFilter() {
			return descriptionFilter;
		}
		public void setDescriptionFilter(String descriptionFilter) {
			this.descriptionFilter = descriptionFilter;
		}
		
	}
}
