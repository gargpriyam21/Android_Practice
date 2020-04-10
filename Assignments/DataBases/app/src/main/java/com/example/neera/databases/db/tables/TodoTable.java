package com.example.neera.databases.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.neera.databases.models.Todo;

import java.util.ArrayList;

import static com.example.neera.databases.db.tables.DbConsts.CMD_CREATE_TABLE_INE;
import static com.example.neera.databases.db.tables.DbConsts.COMMA;
import static com.example.neera.databases.db.tables.DbConsts.LBR;
import static com.example.neera.databases.db.tables.DbConsts.RBR;
import static com.example.neera.databases.db.tables.DbConsts.SEMI;
import static com.example.neera.databases.db.tables.DbConsts.TYPE_AI;
import static com.example.neera.databases.db.tables.DbConsts.TYPE_BOOL;
import static com.example.neera.databases.db.tables.DbConsts.TYPE_INT;
import static com.example.neera.databases.db.tables.DbConsts.TYPE_PK;
import static com.example.neera.databases.db.tables.DbConsts.TYPE_TEXT;

/**
 * Created by Neera on 28/09/17.
 */

public class TodoTable {
    public static final String TABLE_NAME = "todos";
    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Coloumns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Coloumns.TASK + TYPE_TEXT + COMMA +
                    Coloumns.DONE + TYPE_BOOL +
                    RBR +
                    SEMI;

    public static ArrayList<Todo> getAllTodos(SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                new String[]{Coloumns.ID, Coloumns.TASK, Coloumns.DONE},
                null,
                null,
                null,
                null,
                null
        );

        int colForId = c.getColumnIndex(Coloumns.ID);
        int colForTask = c.getColumnIndex(Coloumns.TASK);
        int colForDone = c.getColumnIndex(Coloumns.DONE);
        while (c.moveToNext()) {
            todos.add(
                    new Todo(
                            c.getInt(colForId),
                            c.getString(colForTask),
                            c.getInt(colForDone) != 0
                    )
            );
        }

        return todos;
    }

    public static long insertTodo(SQLiteDatabase db, Todo todo) {
        ContentValues todoData = new ContentValues();
        todoData.put(Coloumns.TASK, todo.getTask());
        todoData.put(Coloumns.DONE, todo.isDone());
        return db.insert(
                TABLE_NAME,
                null,
                todoData
        );
    }

    public static void deleteTodo(SQLiteDatabase db, int todoId) {

    }

    public interface Coloumns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }


}
