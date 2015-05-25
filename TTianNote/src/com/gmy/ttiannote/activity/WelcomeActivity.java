package com.gmy.ttiannote.activity;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.utils.SharepreferenceTools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends BaseActivity implements OnClickListener{
	private final int MSG_GO_TO_MAIN=1;
	private EditText userET,passwordET;
	private Button logInBT,registerBT;
	
	private Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_GO_TO_MAIN:
				Intent mIntent=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(mIntent);
				finish();
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
		initLayout();
		initData();
		
	}
	private void initData() {
		String username=SharepreferenceTools.getString(this, "username", 0);
		if(username!=null ){
			userET.setText(username);
		}

	}
	private void initLayout() {
		// TODO Auto-generated method stub
		userET=(EditText) findViewById(R.id.username_et);
		passwordET=(EditText) findViewById(R.id.password_et);
		
		logInBT=(Button) findViewById(R.id.login_bt);
		registerBT=(Button) findViewById(R.id.register_bt);
		
		logInBT.setOnClickListener(this);
		registerBT.setOnClickListener(this);
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
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_bt:
			String username=SharepreferenceTools.getString(this, "username", 0);
			int password=Integer.parseInt(SharepreferenceTools.getString(this, "password", 1));
	
			if(userET.getText().toString().equals(username) && Integer.parseInt(passwordET.getText().toString())==password){
				Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
				mHandler.sendEmptyMessageDelayed(MSG_GO_TO_MAIN, 1500); //进入主界面
			}else{
				Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.register_bt:
			if(TextUtils.isEmpty(userET.getText()) || TextUtils.isEmpty(passwordET.getText())){
				Toast.makeText(this, "信息未填写完全", Toast.LENGTH_SHORT).show();
			}else {
				SharepreferenceTools.putString(this, userET.getText().toString().trim(), 0);
				SharepreferenceTools.putString(this, passwordET.getText().toString().trim(), 1);
				Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
				mHandler.sendEmptyMessageDelayed(MSG_GO_TO_MAIN, 1500); //进入主界面
			}
			
			break;	

		default:
			break;
		}
	}
}
