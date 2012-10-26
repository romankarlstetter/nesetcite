package fr.ecp.innovationprj.nesetcite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.ecp.innovationprj.nesetcite.mycv.ProfileActivity;
import fr.ecp.innovationprj.nesetcite.mycv.YoungPeopleActivity;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
	}
	
	public void login(View view) {
		startActivity(new Intent(this, ProfileActivity.class));
	}
	
}

