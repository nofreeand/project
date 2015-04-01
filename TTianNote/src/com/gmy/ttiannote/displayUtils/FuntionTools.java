package com.gmy.ttiannote.displayUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;

public class FuntionTools {

	// public static int getScreenWidth(){
	//
	// }

	public static String getTS() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String reqTime = dateFormat.format(new Date());
		return reqTime;
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
