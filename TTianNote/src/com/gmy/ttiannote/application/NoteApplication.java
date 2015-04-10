package com.gmy.ttiannote.application;

import java.io.File;

import android.app.Application;

import com.gmy.ttiannote.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class NoteApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		File cacheDir=StorageUtils.getOwnCacheDirectory(getApplicationContext(), "TTBook/Cache");
		DisplayImageOptions defaultOptions=new DisplayImageOptions
				.Builder()
				.showImageForEmptyUri(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.build();
		ImageLoaderConfiguration config=new ImageLoaderConfiguration
				.Builder(getApplicationContext())
				.defaultDisplayImageOptions(defaultOptions)
				.discCacheSize(50*1024*1024)
				.discCacheFileCount(1000)
				.discCache(new UnlimitedDiskCache(cacheDir))
				.build();
		ImageLoader.getInstance().init(config);
	}
}
