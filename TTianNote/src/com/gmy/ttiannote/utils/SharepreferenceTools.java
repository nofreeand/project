package com.gmy.ttiannote.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharepreferenceTools {
	public static boolean putString(Context context,String msg,int flag){
		SharedPreferences sharedPreferences=context.getSharedPreferences("use_information",Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=sharedPreferences.edit();
		switch (flag) {
		case 0:
			editor.putString("username", msg);
			break;
		case 1:
			editor.putString("password", msg);
			break;
		default:
			break;
		}
		return editor.commit();
	}
	
	public static String getString(Context context,String msg,int flag){
		SharedPreferences sharedPreferences=context.getSharedPreferences("use_information",Context.MODE_PRIVATE);
		String information=null;
		switch (flag) {
		case 0:
			information=sharedPreferences.getString("username",null);
			break;
		case 1:
			information=sharedPreferences.getString("password","0");
			break;
		default:
			break;
		}
		return information;
	}
	
	
}
