package com.codingblocks.databases.db.tables;

/**
 * Created by arnav on 9/24/2017.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codingblocks.databases.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.databases.db.tables.DbConsts.CMD_ADD_COLUMN;
import static com.codingblocks.databases.db.tables.DbConsts.CMD_ALTER_TABLE;
import static com.codingblocks.databases.db.tables.DbConsts.CMD_CREATE_TABLE_INE;
import static com.codingblocks.databases.db.tables.DbConsts.COMMA;
import static com.codingblocks.databases.db.tables.DbConsts.LBR;
import static com.codingblocks.databases.db.tables.DbConsts.RBR;
import static com.codingblocks.databases.db.tables.DbConsts.SEMI;
import static com.codingblocks.databases.db.tables.DbConsts.TYPE_AI;
import static com.codingblocks.databases.db.tables.DbConsts.TYPE_BOOL;
import static com.codingblocks.databases.db.tables.DbConsts.TYPE_INT;
import static com.codingblocks.databases.db.tables.DbConsts.TYPE_PK;
import static com.codingblocks.databases.db.tables.DbConsts.TYPE_TEXT;

public class TodoTable {
    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Columns.TASK + TYPE_TEXT + COMMA +
                    Columns.DONE + TYPE_BOOL +
                    RBR +
                    SEMI;
    public static final String CMD_UPD_1_2 =
            CMD_ALTER_TABLE + TABLE_NAME +
                    CMD_ADD_COLUMN +
                    Columns.DONE + TYPE_BOOL +
                    SEMI;


    public static ArrayList<Todo> getAllTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                new String[] {Columns.ID, Columns.TASK},
                null,
                null,
                null,
                null,
                null
        );
        int colForId = c.getColumnIndex(Columns.ID);
        int colForTask = c.getColumnIndex(Columns.TASK);
        int colForDone = c.getColumnIndex(Columns.DONE);
        while (c.moveToNext()) {
            todos.add(
                    new Todo(
                            c.getInt(colForId),
                            c.getString(colForTask),
                            c.getInt(colForDone) != 0
                    )
            );
        }
        return  todos;
    }

    public static long insertTodo (SQLiteDatabase db, Todo todo) {
        ContentValues todoData = new ContentValues();
        todoData.put(Columns.TASK, todo.getTask());
        todoData.put(Columns.DONE, todo.isDone());
        return db.insert(
                TABLE_NAME,
                null,
                todoData
        );
    }

    public static void deleteTodo (SQLiteDatabase db, int todoId) {

    }


}
