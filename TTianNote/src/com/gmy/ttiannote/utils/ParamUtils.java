package com.gmy.ttiannote.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.text.format.DateFormat;



public class ParamUtils {
	private String imageName=new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))+".jpg";
	
	public static String getTimeStamp(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date(System.currentTimeMillis());
		return format.format(date);
	}
}
