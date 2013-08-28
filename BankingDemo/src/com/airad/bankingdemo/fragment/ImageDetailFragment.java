package com.airad.bankingdemo.fragment;

import com.airad.bankingdemo.MainActivity;
import com.airad.bankingdemo.R;
import com.airad.bankingdemo.model.ImageNews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageDetailFragment extends Fragment {
	private static final String IMAGE_DATA_EXTRA = "extra_image_data";
	private ImageView mImageView;
	protected ImageNews item;

	public static ImageDetailFragment newInstance(ImageNews item) {
		final ImageDetailFragment f = new ImageDetailFragment();
		f.item = item;
		return f;
	}

	public ImageDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.image_detail_fragment,
				container, false);
		mImageView = (ImageView) v.findViewById(R.id.imageView);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (MainActivity.class.isInstance(getActivity())) {
			mImageView.setImageResource(item.getPicIds());
			mImageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					FragmentManager fm = getActivity()
							.getSupportFragmentManager();
					if (fm.findFragmentByTag(NewsListFragment.TAG) == null) {
						FragmentTransaction ft = fm.beginTransaction();
						NewsDetailFragment mNewsDetailFragment = NewsDetailFragment.newInstance(NewsFragment.TAG);
						ft.add(R.id.newsContainer, mNewsDetailFragment,
								NewsDetailFragment.TAG);
						ft.addToBackStack(NewsFragment.TAG);
						ft.commit();
					}
				}
			});
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}// end class
