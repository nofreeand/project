package com.gmy.ttiannote.widget;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.activity.MainActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ListView;

public class TimeListView extends ListView {
	private Paint mPaint;
	
	public TimeListView(Context context) {
		super(context);
		init();
	}

	public TimeListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TimeListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	

	private void init() {
		// TODO Auto-generated method stub
		mPaint=new Paint();
		mPaint.setColor(getResources().getColor(R.color.title_imageview));
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(2);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
//		备用方案需要考虑屏幕适配的问题
		if(MidiconImageView.marginLeft!=0){
			float x=(float) (MidiconImageView.marginLeft);
			canvas.drawLine(x, 0, x, this.getHeight(), mPaint);
		}
	}
}
