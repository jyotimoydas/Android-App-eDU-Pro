package com.webtek.edupro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 20-01-2018.
 */


    public class Dbase extends SQLiteOpenHelper {
        User user;
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "username";
    public static final String COL_2 = "rollno";
    public static final String COL_3 = "password";
    public static final String COL_4 = "branch";
    public static final String COL_5 = "phone";

    public Dbase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (username VARCHAR PRIMARY KEY NOT NULL,rollno VARCHAR NOT NULL,password VARCHAR NOT NULL, branch VARCHAR NOT NULL," +
                " phone VARCHAR NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String username, String rollno, String password, String branch, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query="select * from student_table";
        Cursor cursor=db.rawQuery(query,null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, username);
        contentValues.put(COL_2, rollno);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, branch);
        contentValues.put(COL_5, phone);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result==-1)
        {
            return false;
        }
        else
            return  true;
    }

    public String searchpass(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = ("select username, password from student_table" );
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b="Not Found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);


                if (a.equals(username)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());



        }
        return b;
    }
}




