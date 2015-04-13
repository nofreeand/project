package com.gmy.ttiannote.utils;

import java.util.ArrayList;
import java.util.List;

import com.gmy.ttiannote.dao.NoteContentDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	
	public List<NoteContentDAO> selectSql(Context context,String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,String orderBy){
		SQLiteDatabase sqLiteDatabase=null;
		List<NoteContentDAO> mList=new ArrayList<NoteContentDAO>();
		try {
			sqLiteDatabase=NoteSqliteHelper.getDbHelper(context).getWritableDatabase();
			Cursor mCursor=sqLiteDatabase.query("NoteList", columns, selection, selectionArgs, groupBy, having, orderBy);
			while (mCursor.moveToNext()) {
				NoteContentDAO mDao=new NoteContentDAO();
				mDao.set_id(mCursor.getInt(mCursor.getColumnIndex("_id")));
				mDao.setTitle(mCursor.getString(mCursor.getColumnIndex("title")));
				mDao.setContent(mCursor.getString(mCursor.getColumnIndex("content")));
				mDao.setImagePathOne(mCursor.getString(mCursor.getColumnIndex("imagePathOne")));
				mDao.setImagePathTwo(mCursor.getString(mCursor.getColumnIndex("imagePathTwo")));
				mDao.setImagePathThree(mCursor.getString(mCursor.getColumnIndex("imagePathThree")));
				mDao.setImagePathFour(mCursor.getString(mCursor.getColumnIndex("imagePathFour")));
				mDao.setTime(mCursor.getString(mCursor.getColumnIndex("time")));
				mList.add(mDao);
			}
			mCursor.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			sqLiteDatabase.close();
		}
		return mList;
	}
	
	//使用语句查询
	public List<NoteContentDAO> selectExecSql(Context context,String sqlString){
		SQLiteDatabase sqLiteDatabase=null;
		List<NoteContentDAO> mList=new ArrayList<NoteContentDAO>();
		try {
			sqLiteDatabase=NoteSqliteHelper.getDbHelper(context).getWritableDatabase();
			Cursor mCursor=sqLiteDatabase.rawQuery(sqlString, null);
			while (mCursor.moveToNext()) {
				NoteContentDAO mDao=new NoteContentDAO();
				mDao.set_id(mCursor.getInt(mCursor.getColumnIndex("_id")));
				mDao.setTitle(mCursor.getString(mCursor.getColumnIndex("title")));
				mDao.setContent(mCursor.getString(mCursor.getColumnIndex("content")));
				mDao.setImagePathOne(mCursor.getString(mCursor.getColumnIndex("imagePathOne")));
				mDao.setImagePathTwo(mCursor.getString(mCursor.getColumnIndex("imagePathTwo")));
				mDao.setImagePathThree(mCursor.getString(mCursor.getColumnIndex("imagePathThree")));
				mDao.setImagePathFour(mCursor.getString(mCursor.getColumnIndex("imagePathFour")));
				mDao.setTime(mCursor.getString(mCursor.getColumnIndex("time")));
				mList.add(mDao);
			}
			mCursor.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			sqLiteDatabase.close();
		}
		return mList;
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
