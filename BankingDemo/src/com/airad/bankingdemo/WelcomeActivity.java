package com.airad.bankingdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class WelcomeActivity extends Activity {
	public static final int SPALSH_DURATION = 1500;
	private ImageView leftCloud, rightCloud;
	private boolean isRun=true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		init();
	}

	private void init() {
		leftCloud = (ImageView) findViewById(R.id.left_cloud);
		rightCloud = (ImageView) findViewById(R.id.right_cloud);
		
		Matrix matrix = leftCloud.getImageMatrix();
		matrix.setTranslate(-200f, 0);
		leftCloud.setImageMatrix(matrix);
		leftCloud.invalidate();

		new Thread(new Runnable() {
			int count = 0;

			@Override
			public void run() {
				do {
					handler.sendEmptyMessage(1);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} while (isRun);
				handler.sendEmptyMessage(1);
			}
		}).start();
		
		skipHandler.sendEmptyMessageDelayed(1, 3500);
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Matrix matrix = leftCloud.getImageMatrix();
			matrix.postTranslate(0.3f, 0);
			leftCloud.setImageMatrix(matrix);
			leftCloud.setScaleType(ScaleType.MATRIX);

			Matrix matrix2 = rightCloud.getImageMatrix();
			matrix2.postTranslate(-0.3f, 0);
			rightCloud.setImageMatrix(matrix2);
			rightCloud.setScaleType(ScaleType.MATRIX);

			leftCloud.invalidate();
			rightCloud.invalidate();
		}
	};
	
	private Handler skipHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			skipToMain();
			finish();
		}
	};
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		isRun=false;
	}

	private void skipToMain() {
		Intent it = new Intent(this, MainActivity.class);
		startActivity(it);
	}
	
}// end class
