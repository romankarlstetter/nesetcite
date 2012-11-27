package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import fr.ecp.innovationprj.nesetcite.R;

public class CVItemListFragment extends Fragment {

	
	private FilteredCVItemList itemList;
	
	public CVItemListFragment() {
		itemList = new FilteredCVItemList();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.cv_item_list, null);
		
		ListView listView = (ListView) v.findViewById(R.id.cv_item_listview);
		
		ListAdapter a = new ArrayAdapter<CVItem>(getActivity(), R.layout.cv_item_layout, R.id.cv_item_description, itemList);
        listView.setAdapter(a);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
			}
		});
        return v;
	}
	
	public void setItemList(List<CVItem> list){
		itemList.setList(list);
	}
	
	public void setItemCategory(String cat){
		itemList.setCategory(cat);
	}
}
