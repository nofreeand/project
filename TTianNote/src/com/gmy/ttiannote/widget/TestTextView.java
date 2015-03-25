package com.gmy.ttiannote.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.TextView;

public class TestTextView extends TextView {

	private Paint marginPaint,linePaint;
	private Resources mResources;
	public TestTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}


	public TestTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public TestTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mResources=getResources();
		marginPaint=new Paint(Paint.ANTI_ALIAS_FLAG); //画斜线使用抗锯齿 外线
		marginPaint.setStrokeWidth(12);
		marginPaint.setColor(mResources.getColor(com.gmy.ttiannote.R.color.textview_outline));
		
		linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);//内线
		linePaint.setColor(mResources.getColor(com.gmy.ttiannote.R.color.textview_inline));
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		// TODO Auto-generated method stub
		// canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), marginPaint);
		
		//           注意这块尺寸的换算 R.dimen过来是16进制的数 需要通过getDimension（xxx）换算
	    float magrin=mResources.getDimension(com.gmy.ttiannote.R.dimen.textview_margin);
		canvas.drawRect(magrin,magrin,getMeasuredWidth()-magrin,getMeasuredHeight()-magrin,marginPaint);
		super.onDraw(canvas);
	}
	
}
