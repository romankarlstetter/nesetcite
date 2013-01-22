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
		TextView title = (TextView) convertView.findViewById(R.id.cv_item_title);
		//title.setText(getItem(position).getTitle());
		System.out.println("title: " + getItem(position).getTitle());

		TextView description = (TextView) convertView.findViewById(R.id.cv_item_description);
		description.setText(getItem(position).getDescription());
		
		TextView date = (TextView) convertView.findViewById(R.id.cv_item_date);
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("MMM yy");
		String dateText = "";
		if(getItem(position).getDateStart() != null){			
			dateText = dateFormat.format(getItem(position).getDateStart());
		}
		if (getItem(position).getDateEnd() != null){
			dateText = dateText + " - " + dateFormat.format(getItem(position).getDateEnd());
		}
		//date.setText(dateText);
		System.out.println("datetext: " + dateText);
		return convertView;
		
	}

}
