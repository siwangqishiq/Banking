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
			dataList.add("�й�����ǰ��Ҫ����ծ����ͨ��");
			dataList.add("����ί�·���ҵȯԤ��Ȩ�����ط�����������");
			break;
		case 2:
			dataList.add("�Ϻ���ó��������Ͷ��Э���¹���");
			dataList.add("�Ϻ���̨42���ٴ��ƶ����ڸĸ�");
			dataList.add("�㶫��̨36���ʩ�ƽ�����ǰ����λ");
			break;
		case 3:
			dataList.add("���д����п�ʼ����Ϊ��������г���Ԥ��");
			dataList.add("�й���ʳ�չ���������ӭ���г����ĸ�");
			break;
		case 4:
			dataList.add("�й������г����ܿ콫���ٶ��ƽ�");
			dataList.add("2030���й������˿ڽ�����10��");
			dataList.add("������������ϵ���׼�ؼ��Ի��⳥ծѹ��");
			dataList.add("2013-2017���й���Ͷ��6200��Ԫ���ظ�ѹ���ܵ���");
			break;
		case 5:
			dataList.add("���ڵؼ۸������־�����ĭ���ѵ�ǰ��");
			dataList.add("�����������޷��ٱ����������ľ޴����");
			dataList.add("ŷ������ó�ױ��ݶ��й�������в����");
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
