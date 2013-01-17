package fr.ecp.innovationprj.nesetcite.offers;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOffersProvider extends AbstractOffersProvider {

	private ObjectMapper mapper;
	
	private final static String BASEURL = "json/";
	private Context applicationContext; //TODO remove when real server-requests are done	
	public JsonOffersProvider(Context c) {
		mapper = new ObjectMapper();
		applicationContext = c;
		filter = new OfferFilter();
	}
	
	
	@Override
	public List<Offer> getFilteredOfferList() {
		// TODO: make HTTP-request to server with information, use server-side filtering
		// i.e. something like http://www.nesetcite.com/webservice/offers?title=<titleFilter>&description=<descriptionFilter>
		List<Offer> result = null;
		AssetManager m = applicationContext.getAssets();
		try {
			result = mapper.readValue(m.open(BASEURL + "offers.json"), new TypeReference<List<Offer>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//TODO remove the following line once server-side filtering is implemented
		result = applyFilter(result);
		return result; 
	}

}
