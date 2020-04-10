package com.pratap.ninja.newsapp.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.db.NotesDbHelper;
import com.pratap.ninja.newsapp.db.Table.NotesTable;
import com.pratap.ninja.newsapp.models.Notes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.pratap.ninja.newsapp.MainActivity.setMark;

public class NotesActivity extends AppCompatActivity {

    EditText etTitle, etbody;
    SQLiteDatabase notesDb;
    String body = "";
    String title = "";
    Integer idd, flag;
    Boolean f = false;
    ArrayList<Notes> notesList = new ArrayList<>();
    public static final String TAG = "DB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);


        Intent i = getIntent();
        title = i.getStringExtra("Title");
        body = i.getStringExtra("Body");
        flag = i.getIntExtra("flag", 0);
        idd = i.getIntExtra("Id", -1);
        Log.d(TAG, "onCreate: " + title);
        Log.d(TAG, "onCreate: " + body);
        Log.d(TAG, "onCreate: " + idd);

        notesDb = new NotesDbHelper(this).getWritableDatabase();
        notesList = NotesTable.getAllNotes(notesDb);
        Log.d(TAG, "onCreate: " + notesList.size());

        etbody = (EditText) findViewById(R.id.etNotesAddBody);
        etTitle = (EditText) findViewById(R.id.etNotesAddTitle);

        if (flag == 1) {
            setMark(false);
            Log.d(TAG, "onOptionsItemSelectedddddd: " + idd);
            long notesId = NotesTable.deleteTodo(notesDb, idd);
            finish();
        }

        if (title != null) {
            etTitle.setText(title);
            f = true;
        }
        if (body != null) etbody.setText(body);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.actionSave) {
            Toast.makeText(this, "Saved to Notes", Toast.LENGTH_SHORT).show();
            setMark(false);

            if (etTitle.getText().toString().isEmpty()
                    && etbody.getText().toString().isEmpty()) {

            }
            else {
                String title_sub = etTitle.getText().toString();
                String body_sub = etbody.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                // Create a calendar object that will convert the date and time value in milliseconds to date.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                String date = formatter.format(calendar.getTime());
                if (title_sub.isEmpty()) title = "Title";

                if (f) {
                    Log.d(TAG, "onOptionsItemSelected: " + title_sub);
                    Log.d(TAG, "onOptionsItemSelected: " + body_sub);
                    Log.d(TAG, "onOptionsItemSelectedddddddddddddddd: " + idd);
                    long notesId = NotesTable.updateTodo(notesDb,
                            new Notes(idd, title_sub, body_sub, date)
                    );
                    f = false;
                }
                else {
                    long notesId = NotesTable.insertNotes(notesDb,
                            new Notes(title_sub, body_sub, date)
                    );
                }
            }

            finish();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
