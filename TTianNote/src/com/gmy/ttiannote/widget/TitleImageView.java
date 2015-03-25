package com.gmy.ttiannote.widget;

import com.gmy.ttiannote.R;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.util.AttributeSet;
import android.widget.ImageView;
//背景时间轴展示的最上部的背景图
public class TitleImageView extends ImageView {
	private int width;
	private int height;
	private Paint mPaint;
	
	public TitleImageView(Context context) {
		super(context);
		init();
	}

	public TitleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TitleImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	//控件初始化
	private void init() {
		
		mPaint=new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(getResources().getColor(R.color.title_imageview));//资源文件转换resource.getString/getDimen/getColor
		mPaint.setStrokeJoin(Join.ROUND);
		mPaint.setStrokeWidth(1);
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
		height=this.getHeight();
		width=this.getWidth();
		canvas.drawLine(0,height-1, width, height-1,mPaint);
	}
}
