package com.airad.bankingdemo.fragment;

import com.airad.bankingdemo.MainActivity;
import com.airad.bankingdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BusinessFragment extends Fragment{
	public static final String TAB = "business";
	
	private View view;
	private MainActivity mMainActivity;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.businessfrg, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
