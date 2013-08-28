package com.airad.bankingdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

import com.airad.bankingdemo.R;

public class NewsDetailFragment extends Fragment {
	public static final String TAG="NEWS_DETAIL";
	protected String from;
	private View view;
	private Button mBack;
	private WebView mWebView;
	
	public static NewsDetailFragment newInstance(String from) {
		final NewsDetailFragment f = new NewsDetailFragment();
		f.from = from;
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.news_detail_fragment, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mBack = (Button)view.findViewById(R.id.back);
		mBack.setOnClickListener(new BackOnClick());
		mWebView = (WebView)view.findViewById(R.id.webView);
		mWebView.loadUrl("file:///android_asset/html/news_show.html");
	}
	
	private class BackOnClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getActivity().getSupportFragmentManager();
			fm.popBackStack(from, 1);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}// end class
