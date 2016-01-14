package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HotorNot {
	
	private static final String DB_ID = "ID";
	private static final String DB_NAME = "NAME";
	private static final String DB_HOTNESS = "HOTNESS";
	private static final String DATABASE_NAME = "My_First_DB";
	private static final String DATABASE_TABLE = "My_First_TABLE";
	private static final int DATABASE_VERSION = 1;
	
	private Context c;
	private SQLiteDatabase d;
	private MyDBHelper RealHelper;
	
	private class MyDBHelper extends SQLiteOpenHelper {

		public MyDBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("create table " + DATABASE_TABLE + "("+
					DB_ID + " integer primary key autoincrement not null, "+
					DB_NAME + " text not null, " +
					DB_HOTNESS + " text not null " + ")" );
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("Drop table if exists " + DATABASE_TABLE);
			onCreate(db);
		}
		
	}

	public HotorNot(Context cc) {
		// TODO Auto-generated constructor stub
		c = cc;
	}

	public void open()throws SQLException {
		// TODO Auto-generated method stub
		RealHelper = new MyDBHelper(c);
		d = RealHelper.getWritableDatabase();
		
	}

	public void update(String inputName, String inputHot) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(DB_NAME, inputName);
		cv.put(DB_HOTNESS, inputHot);
		d.insert(DATABASE_TABLE, null, cv);
	}

	public void close() {
		// TODO Auto-generated method stub
		RealHelper.close();
	}

	public String show() {
		// TODO Auto-generated method stub
		String[] col = {DB_ID, DB_NAME, DB_HOTNESS};
		Cursor cc = d.query(DATABASE_TABLE, col, null, null, null, null, null);
		String Result ="";
		int iId = cc.getColumnIndex(DB_ID);
		int iName = cc.getColumnIndex(DB_NAME);
		int iHotness = cc.getColumnIndex(DB_HOTNESS);
		for (cc.moveToFirst(); !cc.isAfterLast(); cc.moveToNext()){
			Result = Result + cc.getString(iId)+"  "+ cc.getString(iName)+"  "+cc.getString(iHotness)+ "\n";
		}
		return Result;
	}
	

}
