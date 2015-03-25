package com.gmy.ttiannote.utils;

import android.R.raw;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NoteSqliteManger {

	public NoteSqliteManger() {
		// TODO Auto-generated constructor stub
	}

	private static NoteSqliteManger nManger;

	public static NoteSqliteManger getInstance() {
		if (nManger == null) {
			return nManger = new NoteSqliteManger();
		}
		return nManger;
	}

	public boolean insertSql(Context context, ContentValues values) {
		SQLiteDatabase sqLiteDatabase = null;
		long row = -1;
		try {
			sqLiteDatabase = NoteSqliteHelper.getDbHelper(context)
					.getWritableDatabase();
			row = sqLiteDatabase.insert("NoteList", null, values);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqLiteDatabase.close();
		}
		if (row == -1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean deleteSql(Context context, String whereClause,
			String[] whereArgs) {
		SQLiteDatabase sqLiteDatabase = null;
		int flag = -1;
		try {
			sqLiteDatabase = NoteSqliteHelper.getDbHelper(context)
					.getWritableDatabase();
			flag = sqLiteDatabase.delete("NoteList", whereClause, whereArgs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqLiteDatabase.close();
		}
		if (flag < 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean updateSql(Context context, ContentValues values,
			String whereClause, String[] whereArgs) {
		SQLiteDatabase sqLiteDatabase = null;
		int flag = -1;
		try {
			sqLiteDatabase = NoteSqliteHelper.getDbHelper(context)
					.getWritableDatabase();
			flag = sqLiteDatabase.update("NoteList", values, whereClause,
					whereArgs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqLiteDatabase.close();
		}
		if (flag < 0) {
			return false;
		} else {
			return true;
		}
	}
}
