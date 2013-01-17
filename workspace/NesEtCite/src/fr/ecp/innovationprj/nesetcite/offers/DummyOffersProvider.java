package fr.ecp.innovationprj.nesetcite.offers;

import java.util.ArrayList;
import java.util.List;

import fr.ecp.innovationprj.nesetcite.offers.Offer.Enterprise;

public class DummyOffersProvider extends AbstractOffersProvider {
	private List<Offer> offers;
	
	public DummyOffersProvider() {
		Enterprise bmw = new Enterprise();
    	bmw.setName("BMW");
    	
    	Enterprise audi = new Enterprise();
    	audi.setName("Audi");
    	
    	Enterprise vw = new Enterprise();
    	vw.setName("VW");
    	
		offers = new ArrayList<Offer>();
    	offers.add(new Offer("Example 1", "this is a very short description", bmw));
    	offers.add(new Offer("Wow 2", "this is a very short description sdf sfd", vw));
    	offers.add(new Offer("Example 3", "this is a very short descriptionsdf", bmw));
    	offers.add(new Offer("ECP 4", "this is a very short descriptions dfsdf ssdfs fsfs gethr", audi));
    	offers.add(new Offer("Example 5", "this is a very short description", vw));
    	offers.add(new Offer("example 6", "this is a very short description jzunzn t", bmw));
    	offers.add(new Offer("Another 7", "this is a very short description  urtz4t 3e4te 4ttr5 45t 5t ", vw));
    	offers.add(new Offer("Blub 8", "this is a very short descriptiont nnbn vnzt", audi));
    	offers.add(new Offer("Bla 9", "this is a very short descriptioneg sdf 3qf sdvs", audi));
    	offers.add(new Offer("Lorem Ipsum 10", "this is a very short descriptions f 2r f", bmw));
    	
    	filter = new OfferFilter();
	}
	
	
	@Override
	public List<Offer> getFilteredOfferList() {
		return applyFilter(offers);
	}

}
