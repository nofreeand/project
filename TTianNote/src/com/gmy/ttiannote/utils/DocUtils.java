package com.gmy.ttiannote.utils;

import java.io.File;
import java.lang.reflect.Field;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

public class DocUtils {
	
	public static Uri getOutputMediaFileUri(Context context){
		return Uri.fromFile(getOutputMediaFile(context));
	} 
	
	private static File getOutputMediaFile(Context context){
		File fileDir=new File(Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_PICTURES), "TTBOOK");
		if(!fileDir.exists()){
			if(!fileDir.mkdirs()){
				Toast.makeText(context, "无法创建媒体问题件了T_T", Toast.LENGTH_SHORT).show();
			}
		}
		File mediaFile=new File(fileDir.getPath()+File.separator+"IMG_"+ParamUtils.getTimeStamp()+".jpg");
		return mediaFile;
		
	}
}
