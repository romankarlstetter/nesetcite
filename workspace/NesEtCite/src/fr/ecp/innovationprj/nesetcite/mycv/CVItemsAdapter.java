package fr.ecp.innovationprj.nesetcite.mycv;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import fr.ecp.innovationprj.nesetcite.R;

public class CVItemsAdapter extends ArrayAdapter<CVItem> {

	public CVItemsAdapter(Context context, List<CVItem> objects) {
		super(context, R.layout.cv_item_layout, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			convertView = inflater.inflate(R.layout.cv_item_layout, null);
		}
		setCVItem(convertView, getItem(position));
		return convertView;
	}
	
	static void setCVItem(View view, CVItem item){
		TextView title = (TextView) view.findViewById(R.id.cv_item_title);
		title.setText(item.getTitle());

		TextView description = (TextView) view.findViewById(R.id.cv_item_description);
		description.setText(item.getDescription());
		
		TextView date = (TextView) view.findViewById(R.id.cv_item_date);
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("MMM yy");
		String dateText = "";
		if(item.getDateStart() != null){			
			dateText = dateFormat.format(item.getDateStart());
		}
		if (item.getDateEnd() != null){
			dateText = dateText + " - " + dateFormat.format(item.getDateEnd());
		}
		date.setText(dateText);
	}

}
