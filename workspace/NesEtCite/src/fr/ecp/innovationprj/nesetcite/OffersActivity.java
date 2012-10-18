package fr.ecp.innovationprj.nesetcite;

import java.util.ArrayList;
import java.util.List;

import fr.ecp.innovationprj.nesetcite.youngpeople.ViewOfferFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OffersActivity extends FragmentActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        ListAdapter a = new OfferAdapter(sampleList());
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(a);
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			 	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			 	ViewOfferFragment f = new ViewOfferFragment();
                ft.replace(R.id.offerFragmentFrame, f);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
			}
		});
    }
    
    private class OfferAdapter extends BaseAdapter {
    	List<Offer> offerList;
    	
    	public OfferAdapter(List<Offer> offerList) {
			this.offerList = offerList;
		}
    	
		@Override
		public int getCount() {
			return offerList.size();
		}

		@Override
		public Object getItem(int position) {
			return offerList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return offerList.hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null)
			{
				// Get a new instance of the row layout view
				LayoutInflater inflater = getLayoutInflater();
				convertView = inflater.inflate(R.layout.offer_list_item, null);
			} 
			TextView title = (TextView) convertView.findViewById(R.id.offerTitle);
			title.setText(offerList.get(position).getTitle());
			
			TextView description = (TextView) convertView.findViewById(R.id.offerDescription);
			description.setText(offerList.get(position).getDescriptionShort());

			TextView company = (TextView) convertView.findViewById(R.id.offerEnterprise);
			company.setText(offerList.get(position).getEnterprise().getName());
			
			return convertView;
		}
    }
    
    private List<Offer> sampleList(){
    	Enterprise bmw = new Enterprise();
    	bmw.setName("BMW");
    	
    	Enterprise audi = new Enterprise();
    	audi.setName("Audi");
    	
    	Enterprise vw = new Enterprise();
    	vw.setName("VW");
    	
    	List<Offer> l = new ArrayList<Offer>();
    	l.add(new Offer("example 1", "this is a very short description", bmw));
    	l.add(new Offer("example 2", "this is a very short description sdf sfd", vw));
    	l.add(new Offer("example 3", "this is a very short descriptionsdf", bmw));
    	l.add(new Offer("example 4", "this is a very short descriptions dfsdf ssdfs fsfs gethr", audi));
    	l.add(new Offer("example 5", "this is a very short description", vw));
    	l.add(new Offer("example 6", "this is a very short description jzunzn t", bmw));
    	l.add(new Offer("example 7", "this is a very short description  urtz4t 3e4te 4ttr5 45t 5t ", vw));
    	l.add(new Offer("example 8", "this is a very short descriptiont nnbn vnzt", audi));
    	l.add(new Offer("example 9", "this is a very short descriptioneg sdf 3qf sdvs", audi));
    	l.add(new Offer("example 10", "this is a very short descriptions f 2r f", bmw));
    	return l;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_offers, menu);
        return true;
    }
}
