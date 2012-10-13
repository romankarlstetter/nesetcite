package fr.ecp.innovationprj.nesetcite.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import fr.ecp.innovationprj.nesetcite.R;

public abstract class InfoFragments  extends Fragment{
	
	protected WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		webView = new WebView(inflater.getContext());
		//webView.loadData(getHtml(), "text/html", "UTF-8");
		webView.loadUrl("file:///android_asset/infos/history.html");
		return webView;
	}
	
	public abstract String getHtml();
	
	public static class HistoryFragment extends InfoFragments{
		@Override
		public String getHtml() {
			return getResources().getString(R.string.info_history);
		}
		
	}
	
	public static class MissionFragment extends InfoFragments{
		@Override
		public String getHtml() {
			return "Mission";
		}
	}
	
	public static class ObjectiveFragment extends InfoFragments{
		@Override
		public String getHtml() {
			return "Objective";
		}
	}
	
	public static class TeamFragment extends InfoFragments{
		@Override
		public String getHtml() {
			return "Équipe";
		}
	}
	
}

