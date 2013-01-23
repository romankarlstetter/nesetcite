package fr.ecp.innovationprj.nesetcite.mycv;

import fr.ecp.innovationprj.nesetcite.R;
import fr.ecp.innovationprj.nesetcite.R.id;
import fr.ecp.innovationprj.nesetcite.R.layout;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class EditCVItemDialog extends DialogFragment {

	private String dialogTitle;
	public interface EditCVItemDialogListener {
        void onFinishEditDialog(String inputText);
    }

	public void setTitle(String title){
		this.dialogTitle = title;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_cvitem_dialog, container);
        CVItem result = new CVItem();
        
        final EditText title = (EditText) view.findViewById(R.id.title);
        result.setTitle(title.getText().toString());
        
        final EditText description = (EditText) view.findViewById(R.id.description);;
        result.setDescription(description.getText().toString());

        final EditText dateFrom = (EditText) view.findViewById(R.id.description);;
        //TextView lbl = (TextView) view.findViewById(R.id.dialog_lbl);
        //lbl.setText(title);
        Button ok = (Button) view.findViewById(R.id.buttonOK);
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Return input text to activiy
				EditCVItemDialogListener activity = (EditCVItemDialogListener) getActivity();
	            activity.onFinishEditDialog(title.getText().toString());
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
