package com.airad.bankingdemo;

import com.airad.bankingdemo.fragment.AboutFragment;
import com.airad.bankingdemo.fragment.BusinessFragment;
import com.airad.bankingdemo.fragment.NewsFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends FragmentActivity {
	public TabHost mTabHost;
	private View newsTab, businessTab, aboutTab;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		mTabHost = (TabHost) findViewById(R.id.tabhost);
		mTabHost.setup();

		newsTab = (View) LayoutInflater.from(this).inflate(
				R.layout.indicator_news, null);
		mTabHost.addTab(mTabHost.newTabSpec(NewsFragment.TAG)
				.setIndicator(newsTab).setContent(R.id.tab1));

		businessTab = (View) LayoutInflater.from(this).inflate(
				R.layout.indicator_business, null);
		mTabHost.addTab(mTabHost.newTabSpec(BusinessFragment.TAB)
				.setIndicator(businessTab).setContent(R.id.tab2));

		aboutTab = (View) LayoutInflater.from(this).inflate(
				R.layout.indicator_about, null);
		mTabHost.addTab(mTabHost.newTabSpec(AboutFragment.TAB)
				.setIndicator(aboutTab).setContent(R.id.tab3));
	}

	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(),
						R.string.pro_exit_cofirm, Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}// end class
