package com.example.neera.firebasedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.neera.firebasedb.adapters.TodoRecyclerAdapter;
import com.example.neera.firebasedb.models.Todo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    Button btnAddTodo;
    EditText etNewTodo;
    FirebaseDatabase database;
    RecyclerView rvTodoList;
    TodoRecyclerAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference todosRef = database.getReference("todos");

        btnAddTodo = (Button) findViewById(R.id.btnAddTodo);
        etNewTodo = (EditText) findViewById(R.id.etNewTodo);
        rvTodoList = (RecyclerView) findViewById(R.id.rvTodoList);
        rvTodoList.setLayoutManager(new LinearLayoutManager(this));

        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();

                todosRef.push().setValue(new Todo(newTodo, false));
            }
        });

        Query todoListQuery = todosRef.limitToLast(20);


    }
}
