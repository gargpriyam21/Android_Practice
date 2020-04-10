package com.example.neera.friendsquiz.HistoryDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.neera.friendsquiz.HistoryDB.Tables.HistoryTable;

/**
 * Created by Neera on 07/10/17.
 */

public class HistoryDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "history.db";
    public static final int DB_VER = 1;

    public HistoryDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HistoryTable.CMD_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
