package com.example.testscreen;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LayoutParams layoutParams=new LayoutParams(fitPX(200),LayoutParams.WRAP_CONTENT);
		TextView textView=new TextView(this);
		textView.setWidth(5);
		textView.setText("ssssssssssssssssss444aaaaaaaaaaaa");
		this.addContentView(textView, layoutParams);
	}
	public int fitPX(int px){
		DisplayMetrics mDisplayMetrics=new DisplayMetrics();
		int width=mDisplayMetrics.widthPixels;
		int height=mDisplayMetrics.heightPixels;
		if(width==1080){
			System.out.println("进入1"+px);
			return px;
		}else{
			double num=Math.sqrt(Math.pow(1024, 2)+Math.pow(600, 2));
			double num2=Math.sqrt(Math.pow(1280, 2)+Math.pow(800, 2));
			double num3=num2/num;
			System.out.println("进入2"+(int)(px*Math.round(num3)));
			return (int)(px*Math.round(num3));
		}
	}
	
}
