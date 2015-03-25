package com.gmy.ttiannote.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteSqliteHelper extends SQLiteOpenHelper {
	
	private String sql="create table if not exists NoteList"+"(_id integer primary key autoincrement,"
						+ "title varchar(50),"
						+ "content varchar(50),"
						+ "imagePath varchar(50),"
						+ "time varchar(50)"
						+ ")";
	private static NoteSqliteHelper sqliteHelper;
	public static NoteSqliteHelper getDbHelper(Context context){
		if(sqliteHelper==null){
			return sqliteHelper=new NoteSqliteHelper(context);
		}
		return sqliteHelper;
	}
	
	
	public NoteSqliteHelper(Context context) {
		super(context,"NoteList", null, 1);
		// TODO Auto-generated constructor stub
	}

	

	public NoteSqliteHelper(Context context, String name,
			CursorFactory factory, int version,
			DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
