package fr.ecp.innovationprj.nesetcite.mycv;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;

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
		descriptionString += "<br /> <strong>Lieu de naissance: </strong> " + p.getBirthplace();
		descriptionString += "<br /> <strong>Telephone: </strong>" + p.getTelephoneNumber();
		descriptionString += "<br /> <strong></strong>";
		details.setText(Html.fromHtml(descriptionString));
		
		Map<String, String> categories = new TreeMap<String, String>();
		categories.put("education", "Éducation");
		categories.put("experiences", "Expériences");
		categories.put("other", "Autre");

		FilteredCVItemList list = new FilteredCVItemList();
		list.setList(p.getCvItems());
		
		ViewGroup v = (ViewGroup) result.findViewById(R.id.profile_layout);
		for(String category: categories.keySet()){
			TextView title = new TextView(getActivity());
			title.setTextSize(20);
			title.setTypeface(Typeface.DEFAULT_BOLD);
			title.setText(categories.get(category));
			v.addView(title);
			
			list.setCategory(category);
			for(CVItem item: list){
				View view = inflater.inflate(R.layout.cv_item_layout, null);
				CVItemsAdapter.setCVItem(view, item);	
				v.addView(view);
			}
		}
				
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
