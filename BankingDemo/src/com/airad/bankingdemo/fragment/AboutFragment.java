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
		item1.setTitle("�����������Ͼ����п�չ���Ĺ�����");
		item1.setThumb("7��30�����磬���������Ͼ�����");
		
		Culture item2 =new Culture();
		item2.setTitle("��ͨ������ҵЭ���ٿ������淶����ר......");
		item2.setThumb("7��30�����磬��ͨ������ҵЭ������");
		
		Culture item3 =new Culture();
		item3.setTitle("�����������򽭷����ƶ��Ӵ��ͻ�����ͼ��");
		item3.setThumb("Ϊ�˽�һ����߷�������");
		
		Culture item4 =new Culture();
		item4.setTitle("�����н���ʡ���м�ǿ�Ͼ������֧���������衽");
		item4.setThumb("8��16����8��24�գ��ڶ���");
		
		Culture item5 =new Culture();
		item5.setTitle("���ַ������Ͼ�����Ͻ���½ֿ�֧...........");
		item5.setThumb("Ϊ��Ч����ͻ���������ɫ��������");
		
		Culture item6 =new Culture();
		item6.setTitle("����ͨ����̩�ݷ��ж�ٴ�ٷ���������............");
		item6.setThumb("һ�ǰѺ��ֳ����ء����ר��");
		
		Culture item7 =new Culture();
		item7.setTitle("���Ͻ�ũ�����вμ�������洫�ݡ�");
		item7.setThumb("8��6�գ������ʵ���洫�����Ͼ�����");
		
		Culture item8 =new Culture();
		item8.setTitle("�����������Ͼ����й淶���񴰿�,������ɫƷ�ơ�");
		item8.setThumb("Ϊ��ʵ���������������ˮƽ����������");
		
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
