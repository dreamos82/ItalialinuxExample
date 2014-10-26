package com.italialinux.sqliteexample.data;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.italialinux.sqliteexample.data.model.Contact;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DB_VERSION=1;
	private static final String DB_NAME="italialinuxcontacts";
	private static final String TAG = "DBHelper";
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_table = "CREATE TABLE my_contacts ( "
		        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
		        + "contact_name TEXT, "
		        + "number TEXT);";
		    db.execSQL(create_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public ContentValues createContentValues(Contact contact){
		ContentValues values = new ContentValues();
		values.put("contact_name", contact.getContact_name());
		values.put("number", contact.getNumber());
		return values;
	}
	
	public boolean insertContact(Contact contact){
		Log.i(TAG, "Inserting Notification");
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = createContentValues(contact);
		long id = db.insert("my_contacts", null, values);
		if(id==-1)
			return false;
		return true;
	}
	
	public List<Contact> getAllContacts(){
	       SQLiteDatabase db = getReadableDatabase();
	       String stringQuery = "SELECT * FROM my_contacts";
	       Cursor resultset = db.rawQuery(stringQuery,null);
	       resultset.moveToFirst();
	       List<Contact> contacts = new ArrayList<Contact>();
	       while(!resultset.isAfterLast()){
	              Long id = resultset.getLong(resultset.getColumnIndex("id"));
	              String name = resultset.getString(resultset.getColumnIndex("contact_name"));
	              String number = resultset.getString(resultset.getColumnIndex("number"));
	              Contact contact = new Contact(id, name, number);
	              contacts.add(contact);
	              resultset.moveToNext();
	       }
	       resultset.close();
	       return contacts;
	}

}
