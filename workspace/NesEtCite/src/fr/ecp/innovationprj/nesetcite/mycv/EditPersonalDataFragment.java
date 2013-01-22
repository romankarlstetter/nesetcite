package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;

public class EditPersonalDataFragment extends Fragment {

	private ProfileAccess profileAccess;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.personal_data, null);

		EditText name = (EditText) result.findViewById(R.id.name);
		name.setText(profileAccess.getProfile().getLastName());
		
		EditText firstName = (EditText) result.findViewById(R.id.firstname);
		firstName.setText(profileAccess.getProfile().getFirstName());

		EditText phoneNumber = (EditText) result.findViewById(R.id.phoneNumber);
		phoneNumber.setText(profileAccess.getProfile().getTelephoneNumber());

		DatePicker birthdayPicker = (DatePicker) result.findViewById(R.id.birthday);
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(profileAccess.getProfile().getBirthday());
		birthdayPicker.updateDate(birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH), birthday.get(Calendar.DAY_OF_MONTH));
		
		return result;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
            profileAccess = (ProfileAccess) activity;
            System.out.println("Setting profileAccess");
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ProfileAccess");
        }
	}
}
