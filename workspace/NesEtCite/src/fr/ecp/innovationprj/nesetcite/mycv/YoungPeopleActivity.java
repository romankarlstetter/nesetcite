package fr.ecp.innovationprj.nesetcite.mycv;

import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.offers.OffersActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class YoungPeopleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young_people);
	}
	
	public void viewProfile(View view) {
		startActivity(new Intent(this, ProfileActivity.class));
    }	

    public void viewOffers(View view) {
    	startActivity(new Intent(this, OffersActivity.class));
    }
}
