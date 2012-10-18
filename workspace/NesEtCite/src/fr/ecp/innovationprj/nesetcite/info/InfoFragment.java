package fr.ecp.innovationprj.nesetcite.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class InfoFragment  extends Fragment{
	
	private WebView webView;
	private String infoFilename;
	protected final static String infoBase = "file:///android_asset/infos/";
	public final static String FILENAME = "fname";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		infoFilename = getArguments() != null ? getArguments().getString(FILENAME) : "";
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		webView = new WebView(inflater.getContext());
		webView.loadUrl(infoBase + infoFilename);
		webView.getSettings().setUseWideViewPort(false);
		webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		webView.setInitialScale(130);
		return webView;
	}
}

