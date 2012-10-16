package fr.ecp.innovationprj.nesetcite.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public abstract class InfoFragments  extends Fragment{
	
	protected WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		webView = new WebView(inflater.getContext());
		webView.loadUrl(infoUrl());
		webView.getSettings().setUseWideViewPort(false);
		webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		webView.setInitialScale(130);
		return webView;
	}
	
	public abstract String infoUrl();
	protected final static String infoBase = "file:///android_asset/infos/";
	
	public static class HistoryFragment extends InfoFragments{
		@Override
		public String infoUrl() {
			return infoBase + "history.html";
		}
		
	}
	
	public static class MissionFragment extends InfoFragments{
		@Override
		public String infoUrl() {
			return infoBase + "mission.html";
		}
	}
	
	public static class ObjectiveFragment extends InfoFragments{
		@Override
		public String infoUrl() {
			return infoBase + "objective.html";
		}
	}
	
	public static class TeamFragment extends InfoFragments{
		@Override
		public String infoUrl() {
			return infoBase + "team.html";
		}
	}
	
}

