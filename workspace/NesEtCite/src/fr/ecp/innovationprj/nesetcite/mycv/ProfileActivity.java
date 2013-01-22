package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innocationprj.nesetcite.information.ProfileInformationAdapter;
import fr.ecp.innovationprj.nesetcite.EditTextDialog;
import fr.ecp.innovationprj.nesetcite.EditTextDialog.EditTextDialogListener;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.TabsAdapter;

public class ProfileActivity extends FragmentActivity implements EditTextDialogListener, ProfileAccess {
    TabHost mTabHost;
    ViewPager  mViewPager;
    TabsAdapter mTabsAdapter;
    List<CVItem> mCVItemList;
    ProfileInformationAdapter profileAdapter;
    private Profile profile;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mCVItemList = new ArrayList<CVItem>();
        
        profileAdapter = new ProfileInformationAdapter(getApplicationContext());
        profile = profileAdapter.getUserProfile();
        
        mViewPager = (ViewPager)findViewById(R.id.pager);
        
        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
        mTabsAdapter.addTab(mTabHost.newTabSpec("profile").setIndicator("Mon Profile"), 
                ProfileFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("personal_data").setIndicator("Personal Data"), EditPersonalDataFragment.class, null);
        Bundle edu = new Bundle();
        edu.putString("category", "education");
        mTabsAdapter.addTab(mTabHost.newTabSpec("education").setIndicator("Formation"), CVItemListFragment.class, edu);
        Bundle exp = new Bundle();
        exp.putString("category", "experiences");
        mTabsAdapter.addTab(mTabHost.newTabSpec("experiences").setIndicator("Expériences pro"), CVItemListFragment.class, exp);
        Bundle other = new Bundle();
        other.putString("category", "other");
        mTabsAdapter.addTab(mTabHost.newTabSpec("other").setIndicator("Activitées"), CVItemListFragment.class, other);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_young_people, menu);
        return true;
    }
    
    
    private static final int IMAGE_PICK = 1;
    
    public void changeFoto(View view) {
    	Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Selectionner Image"), IMAGE_PICK);

    }
    
    public void changeDescription(View view) {
    	
    }
    
    public void changeName(View view) {
    	
    }
    
    public void addCVItem(View view) {
    	FragmentManager fm = getSupportFragmentManager();
        EditTextDialog editTextDialog = new EditTextDialog();
        String tag = mTabHost.getCurrentTabTag();
        editTextDialog.setTitle(tag);
        editTextDialog.show(fm, "fragment_edit_name");

    }

	@Override
	public void onFinishEditDialog(String inputText) {
		CVItem i = new CVItem();
		i.setCategory(mTabHost.getCurrentTabTag());
		i.setDescription(inputText);
		getProfile().addCVItem(i);
	}
	
	public Profile getProfile() {
		return profile;
	}
	

	
}
