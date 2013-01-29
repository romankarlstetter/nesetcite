package fr.ecp.innocationprj.nesetcite.information;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ecp.innovationprj.nesetcite.mycv.Profile;

public class ProfileInformationAdapter {

	private final static String BASEURL = "http://10.0.2.2/nesetcite/";
	private ObjectMapper mapper;
	
	public ProfileInformationAdapter() {
    	mapper = new ObjectMapper();
	}
	
	public Profile getUserProfile() {
		Profile result = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet get = new HttpGet(BASEURL + "profile.json");
			HttpResponse response = httpclient.execute(get);
			result = mapper.readValue(response.getEntity().getContent(), new TypeReference<Profile>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void saveProfileInformation(Profile p) {
		try {
			mapper.writeValue(System.out, p);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
