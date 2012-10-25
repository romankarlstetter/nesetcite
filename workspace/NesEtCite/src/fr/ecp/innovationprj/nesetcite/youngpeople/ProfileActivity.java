package fr.ecp.innovationprj.nesetcite.youngpeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.TabsAdapter;

public class ProfileActivity extends FragmentActivity {
    TabHost mTabHost;
    ViewPager  mViewPager;
    TabsAdapter mTabsAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tabs_pager);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        
        mViewPager = (ViewPager)findViewById(R.id.pager);
        
        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
        
        mTabsAdapter.addTab(mTabHost.newTabSpec("profile").setIndicator("Mon Profile"), 
                ProfileFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("cv").setIndicator("Mon CV"), DummyFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("cv2").setIndicator("BLuB"), DummyFragment.class, null);
        
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
}
