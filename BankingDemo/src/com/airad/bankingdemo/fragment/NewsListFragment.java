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
	protected int type=-1;

	public static NewsListFragment newInstance(int type) {
		final NewsListFragment f = new NewsListFragment();
		f.type = type;
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
		switch(type){
		case 1:
			dataList.add("中国经济前景要紧盯债务与通胀");
			dataList.add("发改委下放企业券预审权便利地方“稳增长”");
			break;
		case 2:
			dataList.add("上海自贸区将引入投资协定新规则");
			dataList.add("上海出台42条举措推动金融改革");
			dataList.add("广东出台36项措施推进提升前海地位");
			break;
		case 3:
			dataList.add("国有大银行开始悄悄为存款利率市场化预热");
			dataList.add("中国粮食收购政策有望迎来市场化改革");
			break;
		case 4:
			dataList.add("中国利率市场化很快将有再度推进");
			dataList.add("2030年中国城市人口将超过10亿");
			dataList.add("多地政府酝酿上调基准地价以缓解偿债压力");
			dataList.add("2013-2017年中国将投资6200亿元建特高压智能电网");
			break;
		case 5:
			dataList.add("国内地价高涨隐现经济泡沫破裂的前兆");
			dataList.add("警惕融资租赁繁荣背后所隐含的巨大风险");
			dataList.add("欧美隐性贸易壁垒对中国出口威胁更大");
			break;
		}
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
