package fr.ecp.innovationprj.nesetcite.info;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import android.widget.TextView;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.TabsAdapter;

public class InformationActivity extends FragmentActivity {
    TabHost mTabHost;
    ViewPager  mViewPager;
    TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tabs_pager);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mViewPager = (ViewPager)findViewById(R.id.pager);

        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);

        mTabsAdapter.addTab(mTabHost.newTabSpec("histoire").setIndicator("Notre\nHistoire"),
                InfoFragments.HistoryFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("mission").setIndicator("Notre\nMission"),
        		InfoFragments.MissionFragment.class, null);        
        mTabsAdapter.addTab(mTabHost.newTabSpec("objetive").setIndicator("Notre\nObjectif"),
        		InfoFragments.ObjectiveFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("team").setIndicator("Notre\nÉquipe"),
        		InfoFragments.TeamFragment.class, null);
        
        for(int i = 0; i<mTabsAdapter.getCount(); i++){
        	TextView title = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); 
        	title.setSingleLine(false);        	
        }
        
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }

    
}