package fr.ecp.innovationprj.nesetcite.offers;

import java.util.List;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.offers.AbstractOffersProvider.OfferFilter;

public class OffersActivity extends FragmentActivity {
	
	OfferAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
//        adapter = new OfferAdapter(new DummyOffersProvider());
        adapter = new OfferAdapter(new JsonOffersProvider(getApplicationContext()));
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        listView.requestFocus();
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
			 	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			 	ViewOfferFragment f = new ViewOfferFragment();
			 	f.setOffer((Offer) adapter.getItem(position));
                ft.replace(R.id.offerFragmentFrame, f);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
			}
		});
    }
    
    public void applyFilter(View view) {
    	/// order by date
    	/// order by category
    	EditText e = (EditText) findViewById(R.id.offerFilter);
    	String filter = e.getText().toString();
    	System.out.println("Applying filter: " + filter);
    	adapter.applyFilter(filter);
    }
    
    private class OfferAdapter extends BaseAdapter {
    	List<Offer> offerList; //cache list in the adapter
    	AbstractOffersProvider provider;

    	public OfferAdapter(AbstractOffersProvider o) {
    		provider = o;
			this.offerList = provider.getFilteredOfferList();
		}
    	
    	public void applyFilter(String s){
    		provider.setFilter(new OfferFilter(s,s));
    		this.offerList = provider.getFilteredOfferList();
    		this.notifyDataSetChanged();
    	}
    	
		@Override
		public int getCount() {
			if(offerList == null){
				return 0;
			}
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
			String t = offerList.get(position).getTitle();
			title.setText(t != null ? t : "");
			
			TextView description = (TextView) convertView.findViewById(R.id.offerDescription);
			String d = offerList.get(position).getDescriptionShort();
			description.setText(d != null ? d : "");

			TextView company = (TextView) convertView.findViewById(R.id.offerEnterprise);
			String c = offerList.get(position).getEnterprise().getName();
			company.setText(c != null ? c : "");
			
			return convertView;
		}
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_offers, menu);
        return true;
    }
}
