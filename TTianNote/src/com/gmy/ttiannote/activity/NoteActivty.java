package com.gmy.ttiannote.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.gmy.ttiannote.R;

public class NoteActivty extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
			Toast.makeText(this,"返回键", Toast.LENGTH_SHORT).show();
			new AlertDialog.Builder(this)
				.setTitle("那个...提示一下您...")
				.setMessage("真的要退出了啊？")
				.setNegativeButton("不写了", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						finish();
					}
			  }).setPositiveButton("在写点吧", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			}).create().show();
		}
		return true;//super.onKeyDown(keyCode, event);		
	}
}
