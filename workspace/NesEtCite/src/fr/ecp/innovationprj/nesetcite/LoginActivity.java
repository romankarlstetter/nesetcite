package fr.ecp.innovationprj.nesetcite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import fr.ecp.innovationprj.nesetcite.mycv.ProfileActivity;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         
	}
	
	public void login(View view) {
		Session.openActiveSession(this, true, new Session.StatusCallback() {
			
			@Override
			public void call(Session session, SessionState state, Exception exception) {
				if(session.isOpened()){
					System.out.println("Make Request!");
					// make request to the /me API
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

					  // callback after Graph API response with user object
					  @Override
					  public void onCompleted(GraphUser user, Response response) {
						  if (user != null) {
							  System.out.println("Facebook name: " + user.getName());
							  System.out.println("Facebook Birthday: " + user.getBirthday());
							  System.out.println("Facebook Username: " + user.getUsername());
							  System.out.println("Facebook Location: " + user.getLocation());
							  startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
						  } else {
							  System.out.println("Facebook Login does not work...");
						  }
					  }
					});
				}
			}
		});
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
}

