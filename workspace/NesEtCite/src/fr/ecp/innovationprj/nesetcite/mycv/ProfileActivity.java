package fr.ecp.innovationprj.nesetcite.mycv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.facebook.Session;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innocationprj.nesetcite.information.ProfileInformationAdapter;
import fr.ecp.innovationprj.nesetcite.EditTextDialog;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.TabsAdapter;

public class ProfileActivity extends FragmentActivity implements ProfileAccess {
    TabHost mTabHost;
    ViewPager  mViewPager;
    TabsAdapter mTabsAdapter;
    ProfileInformationAdapter profileAdapter;
    private Profile profile;
    
	private final static String BASEURL = "http://10.0.2.2/nesetcite/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        
        profileAdapter = new ProfileInformationAdapter();
        profile = profileAdapter.getUserProfile();
        
        mViewPager = (ViewPager)findViewById(R.id.pager);
        
        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
        mTabsAdapter.addTab(mTabHost.newTabSpec("profile").setIndicator("Mon Profile"), 
                ProfileFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("personal_data").setIndicator("Personal Data"), EditPersonalDataFragment.class, null);
        Bundle edu = new Bundle();
        edu.putString("category", "education");
        edu.putString("categoryTitle", "Éducation");
        mTabsAdapter.addTab(mTabHost.newTabSpec("education").setIndicator("Formation"), CVItemListFragment.class, edu);
        Bundle exp = new Bundle();
        exp.putString("category", "experiences");
        exp.putString("categoryTitle", "Éxperience");
        mTabsAdapter.addTab(mTabHost.newTabSpec("experiences").setIndicator("Expériences pro"), CVItemListFragment.class, exp);
        Bundle other = new Bundle();
        other.putString("category", "other");
        other.putString("categoryTitle", "Autre");
        mTabsAdapter.addTab(mTabHost.newTabSpec("other").setIndicator("Activitées"), CVItemListFragment.class, other);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_profile, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.save:
            	saveProfile();
                return true;
            case R.id.logout:
                Session.getActiveSession().closeAndClearTokenInformation();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void saveProfile(){
    	ObjectMapper m = new ObjectMapper();
    	OutputStream out = new ByteArrayOutputStream();
    	try {
			m.writeValue(out, getProfile());
			System.out.println(out.toString());
			
			HttpClient client = new DefaultHttpClient();
	    	HttpPost post = new HttpPost(BASEURL + "dummyReceivePost.php");
	    	//post.setEntity(new StringEntity(out.toString()));
	    	List<NameValuePair> list = new ArrayList<NameValuePair>();
	    	list.add(new BasicNameValuePair("profile", out.toString()));
	    	post.setEntity(new UrlEncodedFormEntity(list));
	    	HttpResponse response = client.execute(post);
	    	// debug
	    	InputStream istr = response.getEntity().getContent();
	    	int c;
	    	while((c = istr.read()) != -1){
	    		System.out.print((char) c);
	    	}
	    	System.out.println();
	    	// end debug
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
    
    
    private static final int IMAGE_PICK = 1;
    
    public void changeFoto(View view) {
    	Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Selectionner Image"), IMAGE_PICK);

    }
    
    public void addCVItem(View view) {
    	FragmentManager fm = getSupportFragmentManager();
        EditTextDialog editTextDialog = new EditTextDialog();
        String tag = mTabHost.getCurrentTabTag();
        editTextDialog.setTitle(tag);
        editTextDialog.show(fm, "fragment_edit_name");

    }
	
	public Profile getProfile() {
		return profile;
	}
}
