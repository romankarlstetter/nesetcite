package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;

public class EditPersonalDataFragment extends Fragment {

	private abstract class PersonalDataTextWatcher implements TextWatcher {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {}
		@Override
		public void afterTextChanged(Editable s) {}
	}
	private ProfileAccess profileAccess;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.personal_data, null);
		final Profile p = profileAccess.getProfile();

		EditText name = (EditText) result.findViewById(R.id.name);
		name.addTextChangedListener(new PersonalDataTextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				p.setLastName(s.toString());
			}
		});
		name.setText(p.getLastName());
		
		
		EditText firstName = (EditText) result.findViewById(R.id.firstname);
		firstName.addTextChangedListener(new PersonalDataTextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				p.setFirstName(s.toString());	
			}
		});
		firstName.setText(p.getFirstName());

		EditText phoneNumber = (EditText) result.findViewById(R.id.phoneNumber);
		phoneNumber.addTextChangedListener(new PersonalDataTextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				p.setTelephoneNumber(s.toString());					
			}
		});
		phoneNumber.setText(p.getTelephoneNumber());

		DatePicker birthdayPicker = (DatePicker) result.findViewById(R.id.birthday);
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(p.getBirthday());
		birthdayPicker.init(birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH), birthday.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				p.setBirthday(new Date(year, monthOfYear, dayOfMonth));
				
			}
		});
		
		EditText birthplace = (EditText) result.findViewById(R.id.birthplace);
		birthplace.addTextChangedListener(new PersonalDataTextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				p.setBirthplace(s.toString());
			}
		});
		birthplace.setText(p.getBirthplace());
		
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
