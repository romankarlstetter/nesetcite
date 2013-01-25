package fr.ecp.innovationprj.nesetcite.mycv;

import java.text.SimpleDateFormat;

import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

	ProfileAccess profileAccess;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.profile_view, null);
		Profile p = profileAccess.getProfile();
		
		TextView name = (TextView) result.findViewById(R.id.name);
		String nameString = p.getFirstName() + " " + p.getLastName();
		name.setText(nameString);
		
		TextView details = (TextView) result.findViewById(R.id.presentation);
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("dd MMM yyyy");
		System.out.println(p.getBirthday());
		String descriptionString = "<strong>Date de naissance: </strong> " + dateFormat.format(p.getBirthday()) + "</br>";
		
		details.setText(Html.fromHtml(descriptionString));
		
		return result;
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
            profileAccess = (ProfileAccess) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ProfileAccess");
        }
	}
}
