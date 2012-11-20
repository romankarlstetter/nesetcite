package fr.ecp.innovationprj.nesetcite.offers;

import java.text.SimpleDateFormat;

import fr.ecp.innovationprj.nesetcite.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewOfferFragment extends Fragment{

	private Offer offer;
	
	public void setOffer(Offer o) {
		offer = o;		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.offer_view, null);
		
		TextView enterpriseName = (TextView) result.findViewById(R.id.offer_view_enterpriseName);
		enterpriseName.setText(offer.getEnterprise().getName());
		
		TextView beginDate = (TextView) result.findViewById(R.id.offer_view_begindate);
		CharSequence date = DateFormat.format("dd MMM yy", offer.getPossibleBeginDate());
		beginDate.setText(date);
		
		TextView type = (TextView) result.findViewById(R.id.offer_view_offerType);
		type.setText(offer.getType());
		
		TextView domain = (TextView) result.findViewById(R.id.offer_view_domain);
		domain.setText(offer.getDomain());
		
		TextView offerDate = (TextView) result.findViewById(R.id.offer_view_date);
		date = DateFormat.format("dd MMM yy", offer.getOfferDate());
		offerDate.setText(date);
		
		TextView decr = (TextView) result.findViewById(R.id.offer_view_description);
		decr.setText(offer.getDescriptionLong());
		
		TextView title = (TextView) result.findViewById(R.id.offer_view_title);
		title.setText(offer.getTitle());
		
		return 	result;
	}
}
