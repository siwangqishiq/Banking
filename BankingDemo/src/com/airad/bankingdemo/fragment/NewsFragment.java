package com.airad.bankingdemo.fragment;

import java.util.ArrayList;

import com.airad.bankingdemo.MainActivity;
import com.airad.bankingdemo.R;
import com.airad.bankingdemo.model.ImageNews;
import com.airad.bankingdemo.model.News;
import com.airad.bankingdemo.ui.GalleryListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsFragment extends Fragment {
	public static final String TAG="NEWS";
	private View view;
	private MainActivity mMainActivity;
	private GalleryListView mListView;
	private View mGalleryView;
	private ViewPager mGallery;
	private TextView headText;
	private ArrayList<News> newsList;
	private ArrayList<ImageNews> imageNewsList;
	private NewsListFragment mNewsListFragment;
	private NewsDetailFragment mNewsDetailFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	private void initData() {
		newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setPicId(R.drawable.news_thumb_1);
		news1.setTitle("【政策】");
		news1.setSecondTitle("三中全会宏观经济要稳");
		News news2 = new News();
		news2.setPicId(R.drawable.news_thumb_2);
		news2.setTitle("【市场】");
		news2.setSecondTitle("苏宁云商确认将筹备申请成立...");
		News news3 = new News();
		news3.setPicId(R.drawable.news_thumb_3);
		news3.setTitle("【经营】");
		news3.setSecondTitle("P2C国家队————江苏省“开鑫贷”");
		News news4 = new News();
		news4.setPicId(R.drawable.news_thumb_4);
		news4.setTitle("【风险】");
		news4.setSecondTitle("警示亚太有出现金融风暴的迹象");
		newsList.add(news1);
		newsList.add(news2);
		newsList.add(news3);
		newsList.add(news4);
		
		newsList.add(news1);
		newsList.add(news2);
		newsList.add(news3);
		newsList.add(news4);

		imageNewsList = new ArrayList<ImageNews>();
		ImageNews item1 = new ImageNews();
		item1.setPicIds(R.drawable.image_news1);
		item1.setTitle("第六届一次会员大会暨六届");
		ImageNews item2 = new ImageNews();
		item2.setPicIds(R.drawable.image_news2);
		item2.setTitle("深圳市银行协会和我行协会举行");
		ImageNews item3 = new ImageNews();
		item3.setPicIds(R.drawable.image_news3);
		item3.setTitle("中银行第一秘书长巡考");
		imageNewsList.add(item1);
		imageNewsList.add(item2);
		imageNewsList.add(item3);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.newsfrg, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();

		mListView = (GalleryListView) view.findViewById(R.id.galleryListView);
		mGalleryView = LayoutInflater.from(getActivity()).inflate(
				R.layout.gallery, null);
		mGallery = (ViewPager) mGalleryView.findViewById(R.id.gallery);
		headText = (TextView) mGalleryView.findViewById(R.id.gallery_text);
		mGallery.setAdapter(new ImagePagerAdapter(getActivity()
				.getSupportFragmentManager()));
		mGallery.setOnPageChangeListener(new OnPageChangeListenerImp());
		mListView.addHeaderView(mGalleryView);
		if (imageNewsList.size() > 0) {
			headText.setText(imageNewsList.get(0).getTitle());
		}

		mListView.setAdapter(new ListAdapter());
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index,
					long arg3) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				if(fm.findFragmentByTag(NewsListFragment.TAG)==null){
					FragmentTransaction ft = fm.beginTransaction();
					if (mNewsListFragment == null) {
						mNewsListFragment = NewsListFragment.newInstance();
					}
					ft.add(R.id.newsContainer, mNewsListFragment,
							NewsListFragment.TAG);
					ft.addToBackStack(TAG);
					ft.commit();
				}
			}
		});
		
	}
	

	private final class ImagePagerAdapter extends FragmentStatePagerAdapter {
		public ImagePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return imageNewsList.size();
		}

		@Override
		public Fragment getItem(int position) {
			return ImageDetailFragment.newInstance(imageNewsList.get(position));
		}
	}// end inner class

	private final class OnPageChangeListenerImp implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int index) {
			headText.setText(imageNewsList.get(index).getTitle());
		}
	}// end inner class

	private final class ListAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ListAdapter() {
			mInflater = LayoutInflater.from(getActivity());
		}

		@Override
		public int getCount() {
			return newsList.size();
		}

		@Override
		public Object getItem(int position) {
			return newsList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return (long) position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.news_item, null);
			}
			News news = newsList.get(position);
			ImageView img = (ImageView) convertView.findViewById(R.id.pic);
			TextView title = (TextView) convertView.findViewById(R.id.title);
			TextView thumb = (TextView) convertView.findViewById(R.id.thumb);
			img.setImageResource(news.getPicId());
			title.setText(news.getTitle());
			thumb.setText(news.getSecondTitle());
			return convertView;
		}

	}// end inner class

}// end class
