package com.gmy.ttiannote.widget;

import com.gmy.ttiannote.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CloudImageView extends ImageView{
	private Paint mPaint;
	private Float left,top,right,bottom;
	private RectF mRectF;
	
	public CloudImageView(Context context) {
		super(context);
		init();
	}

	public CloudImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CloudImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		mPaint=new Paint();
		mPaint.setColor(getResources().getColor(R.color.cloud));
		mPaint.setAntiAlias(true);
		mPaint.setStrokeJoin(Join.ROUND);
		mPaint.setStrokeWidth(3);
		mPaint.setStyle(Style.STROKE);
		
		
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		left=(float) this.getLeft();
		top=(float) this.getTop();
		right=(float) this.getRight();
		bottom=(float) this.getBottom();
		mRectF=new RectF(left, top, right, bottom);
		System.out.println("cloud----"+left+"--"+top+"--"+right+"--"+bottom);
		
		//canvas.drawOval(mRectF, mPaint);
		canvas.drawCircle((right-left)/2, (bottom-top)/2, getWidth()/2-6, mPaint);
	}
}










