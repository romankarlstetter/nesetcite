package fr.ecp.innovationprj.nesetcite;

import fr.ecp.innovationprj.nesetcite.youngpeople.YoungPeopleActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
	}
	
	public void login(View view) {
		startActivity(new Intent(this, YoungPeopleActivity.class));
	}
	
}
