package fr.ecp.innocationprj.nesetcite.information;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetManager;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ecp.innovationprj.nesetcite.mycv.Profile;

public class ProfileInformationAdapter {

	private final static String BASEURL = "json/";
	private ObjectMapper mapper;
	private Context context;
	
	public ProfileInformationAdapter(Context c) {
    	mapper = new ObjectMapper();
    	context = c;
	}
	
	public Profile getUserProfile() {
		Profile result = null;
		AssetManager m = context.getAssets();
		try {
			result = mapper.readValue(m.open(BASEURL + "profile.json"), new TypeReference<Profile>(){});
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
