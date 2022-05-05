package com.example.sagarmatha.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDbHelper {
    private Context mContext;
    private SqlDbHelper dbHelper;
    public ContactDbHelper(Context context){

        mContext = context;
        dbHelper= new SqlDbHelper(mContext);

    }
    public boolean insertContact(int id,String name,String phone){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        db.insert("contacts",null,contentValues);
        return  true;
    }

    public Cursor getContact(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM contacts id = "+id+".",null);
        return cursor;
    }


    public boolean updateContact(int id,String name,String phone){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name",name);
            contentValues.put("phone",phone);

            db.update("contacts",contentValues,"id=?",new String[]{Integer.toString(id)});

            return true;
    }
    public int deleteContact(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
       return db.delete("contacts","id=?", new String[]{Integer.toString(id)});

    }

    public Cursor getAllContact(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM contacts",null);
        return cursor;
    }
}
