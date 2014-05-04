package com.ebt.android.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "npuzzle";
	private static final String TABLE_USERDETAILS = "userdetails";
	// COMMON COLUMN NAME
	private static final String KEY_ID = "id";

	// COLUMNS OF USERDETAILS TABLE
	private static final String KEY_USERDETAILS_USERNAME = "username";
	private static final String KEY_USERDETAILS_MOVES = "moves";

	// CREATING USERDETAILS TABLE
	private static final String CREATE_TABLE_USERDETAILS = "CREATE TABLE "
			+ TABLE_USERDETAILS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERDETAILS_USERNAME
			+ " TEXT," + KEY_USERDETAILS_MOVES + " INTEGER)";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// CREATING TABLES
		db.execSQL(CREATE_TABLE_USERDETAILS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_USERDETAILS);
		onCreate(db);
	}

	// INSERTING DATA INTO USERDETAILS TABLE
	public long insertUserDetails(UserDetails userDetails) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_USERDETAILS_USERNAME, userDetails.getUserName());
		values.put(KEY_USERDETAILS_MOVES, userDetails.getMoves());
		long user_id = db.insert(TABLE_USERDETAILS, null, values);
		return user_id;
	}

	// FETCHING ONE RECORD
	public UserDetails getHighestRecord() {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + TABLE_USERDETAILS +" ORDER BY "+KEY_USERDETAILS_MOVES+" ASC LIMIT 1";
		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null)
			c.moveToFirst();

		UserDetails td = new UserDetails();
		td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		td.setUserName((c.getString(c.getColumnIndex(KEY_USERDETAILS_USERNAME))));
		td.setMoves(c.getInt(c.getColumnIndex(KEY_USERDETAILS_MOVES)));

		return td;
	}
	//FETHING ALL RECORDS
	public ArrayList<UserDetails> getAllRecords() {
	    ArrayList<UserDetails> todos = new ArrayList<UserDetails>();
	    String selectQuery = "SELECT  * FROM " + TABLE_USERDETAILS +" ORDER BY "+KEY_USERDETAILS_MOVES+" ASC LIMIT 10";
	    SQLiteDatabase db = this.getReadableDatabase();
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (c.moveToFirst()) {
	        do {
	        	UserDetails td = new UserDetails();
	            td.setId(c.getInt((c.getColumnIndex(KEY_ID))));
	            td.setUserName((c.getString(c.getColumnIndex(KEY_USERDETAILS_USERNAME))));
	    		td.setMoves(c.getInt(c.getColumnIndex(KEY_USERDETAILS_MOVES)));
	 
	            // adding to todo list
	            todos.add(td);
	        } while (c.moveToNext());
	    }
	    return todos;
	}
	// closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
    
}
