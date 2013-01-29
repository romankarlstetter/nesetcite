package fr.ecp.innovationprj.nesetcite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import fr.ecp.innovationprj.nesetcite.info.InformationActivity;
import fr.ecp.innovationprj.nesetcite.mycv.ProfileActivity;
import fr.ecp.innovationprj.nesetcite.offers.OffersActivity;

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
							  startActivity(new Intent(MainActivity.this, ProfileActivity.class));
						  } else {
							  AlertDialog d = new AlertDialog.Builder(MainActivity.this).create();
							  d.setTitle("Login-Error");
							  d.setMessage("Facebook login failed.");
							  d.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok", new OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									dismissDialog(which);
									
								}
							  });
							  System.out.println("Facebook Login does not work...");
						  }
					  }
					});
				}
			}
		});
    }

    public void openOffers(View view) {
    	startActivity(new Intent(this, OffersActivity.class));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// process facebook login-answer
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
    
}
