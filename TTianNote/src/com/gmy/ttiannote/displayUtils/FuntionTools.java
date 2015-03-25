package com.gmy.ttiannote.displayUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FuntionTools {

	// public static int getScreenWidth(){
	//
	// }

	public static String getTS() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String reqTime = dateFormat.format(new Date());
		return reqTime;
	}
}
