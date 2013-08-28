package com.airad.bankingdemo.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.airad.bankingdemo.R;

public class NewsListFragment extends Fragment {
	public static final String TAG = "NES_LIST";
	private View view;
	private Button mBack;
	private ListView mListView;
	private ArrayList<String> dataList;

	public static NewsListFragment newInstance() {
		final NewsListFragment f = new NewsListFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initData();
		view = inflater.inflate(R.layout.news_list_fragment, container, false);
		return view;
	}

	private void initData() {
		dataList = new ArrayList<String>();
		dataList.add("三中全会宏观经济要稳（稳增长），微观经济要活（微刺激），社会政策要托底（社会体制改革）；");
		dataList.add("下半年宏观经济政策稳增长就要稳投资，重点投资于棚户区改造、信息消费、环保产业、铁路建设和基础设施；");
		dataList.add("中国金融综合监管改革迈出了第一步；");
		dataList.add("铁路投融资体制改革是变相发债");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mBack = (Button) view.findViewById(R.id.back);
		mBack.setOnClickListener(new BackOnClick());
		mListView = (ListView) view.findViewById(R.id.list);
		mListView.setAdapter(new ListDdapter());
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index,
					long arg3) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				NewsDetailFragment mNewsDetailFragment = NewsDetailFragment
						.newInstance(TAG);
				ft.add(R.id.newsContainer, mNewsDetailFragment,
						NewsDetailFragment.TAG);
				ft.addToBackStack(TAG);
				ft.commit();
			}
		});
	}

	private final class ListDdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ListDdapter() {
			mInflater = LayoutInflater.from(getActivity());
		}

		@Override
		public int getCount() {
			return dataList.size();
		}

		@Override
		public Object getItem(int position) {
			return dataList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return (long) position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.news_list_item, null);
			}
			TextView text = (TextView) convertView.findViewById(R.id.content);
			text.setText(dataList.get(position));
			return convertView;
		}

	}

	private class BackOnClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			FragmentManager fm = getActivity().getSupportFragmentManager();
			fm.popBackStack(NewsFragment.TAG, 1);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}// end class
