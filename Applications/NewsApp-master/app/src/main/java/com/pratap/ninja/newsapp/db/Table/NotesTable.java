package com.pratap.ninja.newsapp.db.Table;

/**
 * Created by darsh on 01-10-2017.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.pratap.ninja.newsapp.models.Notes;

import java.util.ArrayList;

import static com.pratap.ninja.newsapp.db.Table.DbConsts.CMD_CREATE_TABLE_INE;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.COMMA;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.LBR;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.RBR;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.SEMI;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.TYPE_AI;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.TYPE_INT;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.TYPE_PK;
import static com.pratap.ninja.newsapp.db.Table.DbConsts.TYPE_TEXT;

public class NotesTable {

    public static final String TABLE_NAME = "mynotes";
    public static final String TAG = "TB";

    public interface Coloumns {
        String ID = "id";
        String TITLE = "title";
        String BODY = "body";
        String DATE = "date";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Coloumns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Coloumns.TITLE + TYPE_TEXT + COMMA +
                    Coloumns.BODY + TYPE_TEXT + COMMA +
                    Coloumns.DATE + TYPE_TEXT +
                    RBR +
                    SEMI;

    public static long insertNotes (SQLiteDatabase db, Notes notes) {
        ContentValues cv = new ContentValues();
        cv.put(Coloumns.TITLE, notes.getTitle());
        cv.put(Coloumns.BODY, notes.getBody());
        cv.put(Coloumns.DATE, notes.getDate());

        return db.insert(TABLE_NAME, null, cv);
    }
//
    public static int updateTodo (SQLiteDatabase db, Notes notes) {
        ContentValues cv = new ContentValues();
        cv.put(Coloumns.TITLE, notes.getTitle());
        cv.put(Coloumns.BODY, notes.getBody());
        cv.put(Coloumns.DATE, notes.getDate());
        Log.d(TAG, "updateTodoooooooooo: " + notes.getId());
        Log.d(TAG, "updateTodo: " + Coloumns.TITLE);

        return db.update(TABLE_NAME, cv, Coloumns.ID +"=?", new String [] {notes.getId().toString()});
    }
//
    public static int deleteTodo (SQLiteDatabase db, Integer i) {
        Log.d(TAG, "deleteTodoiiiiiiiiii: " + i);
        return db.delete(TABLE_NAME, Coloumns.ID+"=?", new String[]{i.toString()});
    }
//
    public static ArrayList<Notes> getAllNotes (SQLiteDatabase db) {
        ArrayList<Notes> notes = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,
                new String[]{Coloumns.ID, Coloumns.TITLE, Coloumns.BODY, Coloumns.DATE},
                null,
                null,
                null,
                null,
                null
        );

        int callforid = c.getColumnIndex(Coloumns.ID);
        int callfortitle = c.getColumnIndex(Coloumns.TITLE);
        int callforbody = c.getColumnIndex(Coloumns.BODY);
        int callfordate = c.getColumnIndex(Coloumns.DATE);

        while (c.moveToNext()) {
            notes.add(
                    new Notes(c.getInt(callforid),
                            c.getString(callfortitle),
                            c.getString(callforbody),
                            c.getString(callfordate)
                    )
            );
        }

        return notes;
    }

}
