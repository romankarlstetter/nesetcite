package fr.ecp.innovationprj.nesetcite;

import fr.ecp.innovationprj.nesetcite.info.InformationActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }
    
    public void openInfo(View view) {
    	Intent intent = new Intent(this, InformationActivity.class);
    	startActivity(intent);
    }
    
    public void openMyCV(View view) {
    	startActivity(new Intent(this, LoginActivity.class));
    }

    public void openOffers(View view) {
    	startActivity(new Intent(this, OffersActivity.class));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
