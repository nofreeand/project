package com.gmy.ttiannote.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.gmy.ttiannote.R;

public class ImageShowActivity extends BaseActivity {
	private ImageView mImageShow;
	private Bitmap mBitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imageshow);
		
		initLayout();
		initData();
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		mImageShow=(ImageView) findViewById(R.id.show_image);
	}

	private void initData() {
		// TODO Auto-generated method stub
		Intent mIntent=this.getIntent();
		String imagePath=mIntent.getStringExtra("pic");
		if(mBitmap!=null){
			mBitmap.recycle();
		}
		mBitmap=BitmapFactory.decodeFile(imagePath);
		mImageShow.setImageBitmap(mBitmap);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mBitmap.recycle();
	}
}
