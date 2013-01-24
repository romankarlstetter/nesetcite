package fr.ecp.innovationprj.nesetcite.mycv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import fr.ecp.innocationprj.nesetcite.information.ProfileAccess;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.mycv.EditCVItemDialog.EditCVItemDialogListener;

public class CVItemListFragment extends Fragment implements EditCVItemDialogListener {

	
	private FilteredCVItemList itemList;
	private ProfileAccess profileAccess;
	private String listCategory;
	private String categoryTitle;
	private ArrayAdapter<CVItem> adapter;
	
	@Override
	public void onFinishCVItemDialog(CVItem item) {
		item.setCategory(listCategory);
		profileAccess.getProfile().addCVItem(item);
		adapter.notifyDataSetChanged();
	}
	
	public CVItemListFragment() {
		itemList = new FilteredCVItemList();
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listCategory = getArguments().getString("category");
		categoryTitle = getArguments().getString("categoryTitle");
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_cvitems, menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
            	addCVItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
	
	public void addCVItem(){
		EditCVItemDialog d = new EditCVItemDialog(this);
		d.setTitle(categoryTitle);
		d.show(getFragmentManager(), listCategory);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.cv_item_list, null);
		
		ListView listView = (ListView) v.findViewById(R.id.cv_item_listview);
		
		adapter = new CVItemsAdapter(getActivity().getApplicationContext(), itemList);
        listView.setAdapter(adapter);
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
		
		adapter.notifyDataSetChanged();
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
