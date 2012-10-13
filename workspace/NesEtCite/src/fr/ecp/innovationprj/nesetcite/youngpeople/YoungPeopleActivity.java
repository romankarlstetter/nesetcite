package fr.ecp.innovationprj.nesetcite.youngpeople;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import fr.ecp.innovationprj.nesetcite.R;

public class YoungPeopleActivity extends FragmentActivity{

	private ProfileFragment f = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        f = new ProfileFragment();        	
        setContentView(R.layout.activity_young_people);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_young_people, menu);
        return true;
    }
    
    public void viewProfile(View view) {
    	FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	transaction.replace(R.id.fragment_container, f);
    	transaction.addToBackStack(null);
    	transaction.commit();

    }
    
    public void viewOffers(View view) {
    	
    }
}
