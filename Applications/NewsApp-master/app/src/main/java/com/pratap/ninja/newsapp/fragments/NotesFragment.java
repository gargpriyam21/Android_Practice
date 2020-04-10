package com.pratap.ninja.newsapp.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pratap.ninja.newsapp.R;
import com.pratap.ninja.newsapp.adapters.NotesAdapter;
import com.pratap.ninja.newsapp.db.NotesDbHelper;
import com.pratap.ninja.newsapp.db.Table.NotesTable;
import com.pratap.ninja.newsapp.models.Notes;

import java.util.ArrayList;

public class NotesFragment extends Fragment {

    RecyclerView rvNotes;
    NotesAdapter adapter;
    SQLiteDatabase notesDb;
    ArrayList<Notes> notesList = new ArrayList<>();
    public static final String TAG = "FT";

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View notesFragment = inflater.inflate(R.layout.fragment_notes, container, false);

        rvNotes = notesFragment.findViewById(R.id.rvNotes);
        notesDb = new NotesDbHelper(getContext()).getWritableDatabase();
        notesList = NotesTable.getAllNotes(notesDb);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new NotesAdapter(getContext());
        rvNotes.setLayoutManager(layoutManager);
        rvNotes.setAdapter(adapter);

        adapter.updateNotes(notesList);
        Log.d(TAG, "onCreateView: ");

        return notesFragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        notesList = NotesTable.getAllNotes(notesDb);
        adapter.updateNotes(notesList);
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        notesList = NotesTable.getAllNotes(notesDb);
        adapter.updateNotes(notesList);

        Log.d(TAG, "onStart: " + notesList.size());
    }


}
