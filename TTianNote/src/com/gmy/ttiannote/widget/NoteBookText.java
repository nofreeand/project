package com.gmy.ttiannote.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.EditText;

public class NoteBookText extends EditText {
	private int lineColor,lineRecColor,screenHeight,screenWidth; 
	            //横线颜色
	private float lineWidth,lineRecWidth;//横线宽度
	
	
	public NoteBookText(Context context) {
		super(context);
		init();
	}

	public NoteBookText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public NoteBookText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint mPaint=new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStrokeWidth(lineWidth);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(lineColor);
		int top=this.getPaddingTop();
		int bottom=this.getPaddingBottom();
		int left=this.getPaddingLeft();
		int right=this.getPaddingRight();
		
		
		/*设置size的值是一个核心问题，size的值要适应不同的字体大小（不同大小字体的行距也不同）
	     *经过多次尝试发现以字体大小的7/6倍作为横栏间距最合适
	     * */
//		float lineSize=this.getTextSize()*7/6; //行宽
//		int lineNum= (int) (screenHeight/lineSize);
//		
//		int lineSize2=this.getLineHeight();
//		int   lineNum2=this.getLineCount();
//		for(int x=0;x<lineNum2;x++){
//			float lineY=((x+1)*lineSize2*1.008f);
//			canvas.drawLine(left,lineY+top,
//						    this.getWidth()-right, lineY+top, 
//						    mPaint);
//		}
	}
	
	private void init() {
		// TODO Auto-generated method stub
		lineColor=Color.YELLOW;
		lineWidth=2.0f;
		screenHeight=this.getHeight();
		screenWidth=this.getWidth();
		
		lineRecWidth=1.0f;
		lineRecColor=Color.BLACK;
	}
}
