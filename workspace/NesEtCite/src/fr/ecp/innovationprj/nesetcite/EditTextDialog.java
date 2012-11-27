package fr.ecp.innovationprj.nesetcite;

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

public class EditTextDialog extends DialogFragment {

	private EditText mEditText;
	private String title;
	public interface EditTextDialogListener {
        void onFinishEditDialog(String inputText);
    }

	public void setTitle(String title){
		this.title = title;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_text_dialog, container);
        mEditText = (EditText) view.findViewById(R.id.dialog_txt_field);
        //TextView lbl = (TextView) view.findViewById(R.id.dialog_lbl);
        //lbl.setText(title);
        Button ok = (Button) view.findViewById(R.id.buttonOK);
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Return input text to activiy
				EditTextDialogListener activity = (EditTextDialogListener) getActivity();
	            activity.onFinishEditDialog(mEditText.getText().toString());
	            EditTextDialog.this.dismiss();
			}
		});

        // Show soft keyboard automatically
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Add " + title);

        return view;
    }
}
