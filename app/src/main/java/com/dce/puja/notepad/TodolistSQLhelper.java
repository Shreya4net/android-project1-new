package com.dce.puja.notepad;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.provider.BaseColumns;


/**
 * Created by Devendra on 4/26/2017.
 */

public class TodolistSQLhelper extends SQLiteOpenHelper{
    public static final String DB_NAME = "com.dce.puja.notepad";
    public static final String TABLE_NAME = "TODO_LIST";
    public static final String COL1_TASK = "todo";
    public static final String _ID = BaseColumns._ID;

    public TodolistSQLhelper(Context context) {
        //1 is todo list database version
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String createTodoListTable = "CREATE TABLE " + TABLE_NAME + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1_TASK + " TEXT)";
        sqlDB.execSQL(createTodoListTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqlDB);
    }
}
