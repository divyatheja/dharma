package com.palthady.dharma.activity.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "MyDBName.db";
	public static final String CONTACTS_TABLE_NAME = "contacts";
	public static final String CONTACTS_COLUMN_ID = "id";
	public static final String CONTACTS_COLUMN_PHONE = "phone";
	private HashMap hp;

	public DBHelper(Context context) {
		super(context, DATABASE_NAME , null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(
				"create table contacts " +
						"(id integer primary key, phone text)"
		);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS contacts");
		onCreate(db);
	}

	public boolean insertContact ( String phone) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("phone", phone);
		db.insert("contacts", null, contentValues);
		return true;
	}

	public Cursor getData(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
		return res;
	}

	public int numberOfRows(){
		SQLiteDatabase db = this.getReadableDatabase();
		int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
		return numRows;
	}

	public ArrayList<String> getAllCotacts() {
		ArrayList<String> array_list = new ArrayList<String>();

		//hp = new HashMap();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res =  db.rawQuery( "select * from contacts", null );
		res.moveToFirst();

		while(res.isAfterLast() == false){
			array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_PHONE)));
			res.moveToNext();
		}
		return array_list;
	}
}