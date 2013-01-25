package fr.ecp.innovationprj.nesetcite.mycv;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import fr.ecp.innovationprj.nesetcite.R;

public class EditCVItemDialog extends DialogFragment {

	private String dialogTitle;
	private EditCVItemDialogListener resultListener;
	private final static int PLUSYEARS = 3;
	private final static int YEARSCOUNT = 50;
	
	public interface EditCVItemDialogListener {
        void onFinishCVItemDialog(CVItem item);
    }

	public void setTitle(String title){
		this.dialogTitle = title;
	}
	
	public EditCVItemDialog(EditCVItemDialogListener listener) {
		resultListener = listener;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_cvitem_dialog, container);
        
        final EditText title = (EditText) view.findViewById(R.id.title);
        
        final EditText description = (EditText) view.findViewById(R.id.description);;

        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int thisMonth = Calendar.getInstance().get(Calendar.MONTH);
        
        Integer m[] = new Integer[12];
        for(int i = 0; i<12; i++){
        	m[i] = Integer.valueOf(i+1);
        }
        SpinnerAdapter months = new ArrayAdapter<Integer>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, m);
        
        Integer y[] = new Integer[YEARSCOUNT];
        System.out.println(thisYear);
        for(int i = 0; i<YEARSCOUNT; i++){
        	y[i] = Integer.valueOf(thisYear + PLUSYEARS-i);
        	
        }
        SpinnerAdapter years = new ArrayAdapter<Integer>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, y);
        
        final Spinner dateFromMonth = (Spinner) view.findViewById(R.id.dateFromMonth);
        final Spinner dateFromYear = (Spinner) view.findViewById(R.id.dateFromYear);
        final Spinner dateToMonth = (Spinner) view.findViewById(R.id.dateToMonth);
        final Spinner dateToYear = (Spinner) view.findViewById(R.id.dateToYear);
   		dateFromMonth.setAdapter(months);
   		dateFromYear.setAdapter(years);
   		dateToMonth.setAdapter(months);
   		dateToYear.setAdapter(years);
   		
   		dateFromMonth.setSelection(thisMonth-1); // select this month
   		dateFromMonth.setSelection(thisMonth-1);
   		dateFromYear.setSelection(PLUSYEARS); // select this year
   		dateToYear.setSelection(PLUSYEARS);
   		

        Button ok = (Button) view.findViewById(R.id.buttonOK);
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Return input text to activiy
				CVItem item = new CVItem();
				item.setTitle(title.getText().toString());
				item.setDescription(description.getText().toString());
				
				Date dateFrom = new Date();
				dateFrom.setMonth((Integer)dateFromMonth.getSelectedItem());
				dateFrom.setYear((Integer)dateFromYear.getSelectedItem());
				item.setDateStart(dateFrom);

				Date dateTo = new Date();
				dateTo.setMonth((Integer)dateToMonth.getSelectedItem());
				dateTo.setYear((Integer)dateToYear.getSelectedItem());
				item.setDateEnd(dateTo);
				
				resultListener.onFinishCVItemDialog(item);
	            EditCVItemDialog.this.dismiss();
			}
		});

        // Show soft keyboard automatically
        title.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Add " + dialogTitle);

        return view;
    }
}
