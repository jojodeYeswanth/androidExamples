package com.jojo.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "contactDatabase.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "contact";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String COL_EMAIL = "email";
    public static final String COL_DOB = "dob";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" + COL_NAME + " TEXT PRIMARY KEY,"
                    + COL_PHONE + " TEXT,"
                    + COL_EMAIL + " TEXT,"
                    + COL_DOB + " TEXT)";

    public dbHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        this.onCreate(db);
    }
    public long insertData(String name, String phone, String email, String dob){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PHONE, phone);
        values.put(COL_EMAIL, email);
        values.put(COL_DOB, dob);
        long id = database.insert(TABLE_NAME, null, values);
        database.close();
        return id;
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}
