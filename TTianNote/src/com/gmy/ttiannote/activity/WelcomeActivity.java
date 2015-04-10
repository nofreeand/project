package com.gmy.ttiannote.activity;

import com.gmy.ttiannote.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends BaseActivity{
	private final int MSG_GO_TO_MAIN=1;
	
	private Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_GO_TO_MAIN:
				Intent mIntent=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(mIntent);
				break;

			default:
				break;
			}
			
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		mHandler.sendEmptyMessageDelayed(MSG_GO_TO_MAIN, 1500);
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}
}
