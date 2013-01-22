package fr.ecp.innovationprj.nesetcite.mycv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;

public class CVItemListFragment extends Fragment {

	
	private FilteredCVItemList itemList;
	private ProfileAccess profileAccess;
	private String listCategory;
	
	public CVItemListFragment() {
		itemList = new FilteredCVItemList();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listCategory = getArguments().getString("category");
		System.out.println("settings category:" + listCategory);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.cv_item_list, null);
		
		ListView listView = (ListView) v.findViewById(R.id.cv_item_listview);
		
		ArrayAdapter<CVItem> a = new CVItemsAdapter(getActivity().getApplicationContext(), itemList);
        listView.setAdapter(a);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
			}
		});
		itemList.setList(profileAccess.getProfile().getCvItems());
		itemList.setCategory(listCategory);
		System.out.println("List " + listCategory);
		for(CVItem i: itemList){
			System.out.println(i);
		}
		
		a.notifyDataSetChanged();
        return v;
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
