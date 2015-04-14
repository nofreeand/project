package com.gmy.ttiannote.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;



public class ParamUtils {
	
	public static String getTimeStamp(){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date(System.currentTimeMillis());
		return format.format(date);
	}
	public static String getImageName(){
		String imageNameString=new DateFormat().
				format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))+".jpg";
		Log.i("imageName------", imageNameString);
		return imageNameString;
	}
	
	private void galleryAddPic(Context context,String path) {
	    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
	    File f = new File(path);
	    Uri contentUri = Uri.fromFile(f);
	    mediaScanIntent.setData(contentUri);
	    context.sendBroadcast(mediaScanIntent);
	}

	public static Bitmap getSecondBitmap(ImageView imageView,String imagePath) {
	    // Get the dimensions of the View
	    int targetW = imageView.getWidth();
	    int targetH = imageView.getHeight();

	    // Get the dimensions of the bitmap
	    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	    bmOptions.inJustDecodeBounds = true;
	    BitmapFactory.decodeFile(imagePath, bmOptions);
	    int photoW = bmOptions.outWidth;
	    int photoH = bmOptions.outHeight;

	    // Determine how much to scale down the image
	    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

	    // Decode the image file into a Bitmap sized to fill the View
	    bmOptions.inJustDecodeBounds = false;
	    bmOptions.inSampleSize = scaleFactor;
	    bmOptions.inPurgeable = true;

	    Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);
	    return bitmap;
	}
	
	public static Bitmap getSecondBitmap(int width,int height,String imagePath) {
	    // Get the dimensions of the View
	    int targetW = width;
	    int targetH = height;

	    // Get the dimensions of the bitmap
	    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	    bmOptions.inJustDecodeBounds = true;
	    BitmapFactory.decodeFile(imagePath, bmOptions);
	    int photoW = bmOptions.outWidth;
	    int photoH = bmOptions.outHeight;

	    // Determine how much to scale down the image
	    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

	    // Decode the image file into a Bitmap sized to fill the View
	    bmOptions.inJustDecodeBounds = false;
	    bmOptions.inSampleSize = scaleFactor;
	    bmOptions.inPurgeable = true;

	    Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);
	    return bitmap;
	}
	
	public static int[] getScreenSize(Context context){
		WindowManager mWindowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		int screenWidth = mWindowManager.getDefaultDisplay().getWidth();
		int screenHeight = mWindowManager.getDefaultDisplay().getHeight();
		return new int[]{screenWidth,screenHeight};//宽，高
	}
	
	
}
