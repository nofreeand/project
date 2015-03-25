package com.gmy.ttiannote.widget;

import com.gmy.ttiannote.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MidiconImageView extends ImageView {
	private int marginTop,magrinBottm,viewHeight,viewWidth;
	private Paint mPaint;
	public static int marginLeft;
	
	public MidiconImageView(Context context) {
		super(context);
		init();
	}

	public MidiconImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MidiconImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(1);
		mPaint.setStrokeJoin(Join.ROUND);
		mPaint.setColor(getResources().getColor(R.color.title_imageview));
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int[] mLocation=new int[2];
		this.getLocationOnScreen(mLocation); //屏幕中的x,y坐标
		marginLeft=this.getLeft()+this.getWidth()/2;
		magrinBottm=this.getBottom();
		viewHeight=this.getHeight();
		viewWidth=this.getWidth();
		
	}
	

}
