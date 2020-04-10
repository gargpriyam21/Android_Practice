package com.example.neera.assignmentadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etCourse, etTeacher, etClasses;
    Button btnAdd;
    RecyclerView rvList;
    ArrayList<Course> courses = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCourse = (EditText) findViewById(R.id.etCourse);
        etTeacher = (EditText) findViewById(R.id.etTeacher);
        etClasses = (EditText) findViewById(R.id.etClasses);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rvList = (RecyclerView) findViewById(R.id.rvList);

        btnAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Course newCourse = new Course(
                        etCourse.getText().toString(),
                        etTeacher.getText().toString(),
                        Integer.parseInt(etClasses.getText().toString())
                );
                courses.add(newCourse);

                rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                RecyclerAdapter myAdapter = new RecyclerAdapter(
                        MainActivity.this,
                        courses
                );
                rvList.setAdapter(myAdapter);
                etClasses.setText(null);
                etTeacher.setText(null);
                etCourse.setText(null);
                myAdapter.notifyDataSetChanged();
            }
        });


    }
}
