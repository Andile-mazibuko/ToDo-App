package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "list_db";
    private static final String ITEM_TITLE = "item_title";
    private  static final String TASK_LIST = "list";
    private static final String PRIORITY = "priority";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "list_tbl";
    private static final String TASK_DATE = "task_date";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DB_VERSION);
        //CREATE DATABASE
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREATE TABLE
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM_TITLE + " TEXT," + PRIORITY +"  TEXT,"+ TASK_LIST +"  TEXT,"+ TASK_DATE +" TEXT)") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addItem(String title,String content,String priority,String taskDue)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_TITLE,title);
        contentValues.put(TASK_LIST,content);
        contentValues.put(PRIORITY,priority);
        contentValues.put(TASK_DATE, taskDue);

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

    }
    public Cursor getAllItems()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //returns a cursor
        return sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME,null );

    }


}
