package com.airad.bankingdemo.fragment;

import java.util.ArrayList;

import com.airad.bankingdemo.MainActivity;
import com.airad.bankingdemo.R;
import com.airad.bankingdemo.model.Culture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AboutFragment extends Fragment{
	public static final String TAB = "about";
	private View view;
	private MainActivity mMainActivity;
	private ListView mListView;
	private ArrayList<Culture> dataList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initData();
		view =  inflater.inflate(R.layout.aboutfrg, container,
				false);
		return view;
	}
	
	private void  initData(){
		dataList = new ArrayList<Culture>();
		Culture item1 =new Culture();
		item1.setTitle("〖渤海银行南京分行开展爱心公益活动〗");
		item1.setThumb("7月30日上午，渤海银行南京分行");
		
		Culture item2 =new Culture();
		item2.setTitle("南通市银行业协会召开文明规范服务专......");
		item2.setThumb("7月30日上午，南通市银行业协会文明");
		
		Culture item3 =new Culture();
		item3.setTitle("〖江苏银行镇江分行制定接待客户流程图〗");
		item3.setThumb("为了进一步提高服务质量");
		
		Culture item4 =new Culture();
		item4.setTitle("〖中行江苏省分行加强南京亚青会支付环境建设〗");
		item4.setThumb("8月16日至8月24日，第二届");
		
		Culture item5 =new Culture();
		item5.setTitle("〖浦发银行南京分行辖属新街口支...........");
		item5.setThumb("为有效服务客户，倡导绿色环保理念");
		
		Culture item6 =new Culture();
		item6.setTitle("〖交通银行泰州分行多举措促服务质量提............");
		item6.setThumb("一是把好现场检查关。抽调专人");
		
		Culture item7 =new Culture();
		item7.setTitle("〖紫金农商银行参加亚青会火炬传递〗");
		item7.setThumb("8月6日，亚青会实体火炬传递在南京举行");
		
		Culture item8 =new Culture();
		item8.setTitle("〖宁波银行南京分行规范服务窗口,创建特色品牌〗");
		item8.setThumb("为切实提升分行整体服务水平，提升厅堂");
		
		dataList.add(item1);
		dataList.add(item2);
		dataList.add(item3);
		dataList.add(item4);
		dataList.add(item5);
		dataList.add(item6);
		dataList.add(item7);
		dataList.add(item8);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mListView = (ListView)view.findViewById(R.id.list);
		mListView.setAdapter(new ListDdapter());
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
				convertView = mInflater.inflate(R.layout.culture_list_item, null);
			}
			Culture item = dataList.get(position);
			TextView title = (TextView) convertView.findViewById(R.id.title);
			TextView thumb = (TextView) convertView.findViewById(R.id.thumb);
			title.setText(item.getTitle());
			thumb.setText(item.getThumb());
			return convertView;
		}

	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
