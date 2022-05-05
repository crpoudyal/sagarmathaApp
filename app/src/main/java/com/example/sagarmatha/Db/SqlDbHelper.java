package com.example.sagarmatha.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDbHelper extends SQLiteOpenHelper {

    public static   String DATABASE_NAME = "my_db";
    public static int DB_VERSION= 1;

    public SqlDbHelper(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE contacts"+" (id integer PRIMARY KEY,name text,phone text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");

    }
}
