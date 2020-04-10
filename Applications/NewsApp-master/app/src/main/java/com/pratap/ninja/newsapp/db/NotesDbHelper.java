package com.pratap.ninja.newsapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pratap.ninja.newsapp.db.Table.NotesTable;

/**
 * Created by darsh on 01-10-2017.
 */

public class NotesDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "mynotes.db";
    public static final int DB_VER = 1;
    public NotesDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotesTable.CMD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
