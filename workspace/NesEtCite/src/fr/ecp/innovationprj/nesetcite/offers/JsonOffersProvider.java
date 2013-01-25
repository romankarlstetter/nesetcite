package fr.ecp.innovationprj.nesetcite.offers;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.res.AssetManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOffersProvider extends AbstractOffersProvider {

	private ObjectMapper mapper;
	
	private final static String BASEURL = "http://10.0.2.2/nesetcite/";
	public JsonOffersProvider(Context c) {
		mapper = new ObjectMapper();
		filter = new OfferFilter();
	}
	
	
	@Override
	public List<Offer> getFilteredOfferList() {
		List<Offer> result = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet get = new HttpGet(BASEURL + "offers.json");
			HttpResponse response = httpclient.execute(get);
			result = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Offer>>(){});
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
