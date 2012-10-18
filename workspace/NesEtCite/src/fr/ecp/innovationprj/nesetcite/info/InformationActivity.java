package fr.ecp.innovationprj.nesetcite.info;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.TabsAdapter;

public class InformationActivity extends FragmentActivity {
    TabHost mTabHost;
    ViewPager  mViewPager;
    TabsAdapter mTabsAdapter;
    
    class Tripel{
    	public String filename;
    	public String tabTag;
    	public String tabTitle;
    	public Tripel(String filename, String tabTag, String tabTitle) {
    		this.filename = filename;
    		this.tabTag = tabTag;
    		this.tabTitle = tabTitle;
    	}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tabs_pager);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mViewPager = (ViewPager)findViewById(R.id.pager);

        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);
        
        Tripel[] infos = new Tripel[4];
        infos[0] = new Tripel("history.html", "history", "Notre\nHistoire");
        infos[1] = new Tripel("team.html", "history", "Notre\nÉquipe");
        infos[2] = new Tripel("mission.html", "mission", "Notre\nMission");
        infos[3] = new Tripel("objective.html", "objective", "Notre\nObjectif");
        
        for(Tripel info: infos){
        	Bundle b = new Bundle();
        	b.putString(InfoFragment.FILENAME, info.filename);
        	mTabsAdapter.addTab(mTabHost.newTabSpec(info.tabTag).setIndicator(info.tabTitle), 
                  InfoFragment.class, b);
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