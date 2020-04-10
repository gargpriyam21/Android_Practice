package com.example.neera.extratp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RvList;
    Button btnAdd;
    EditText etCourse, etTeacher, etClasses;
    ArrayList<Course> courses = new ArrayList<>();

    /*
    * ________         ________       _______________  \              /             /\                  |\              /|
    * |       \        |       \            |           \            /             /  \                 | \            / |
    * |        \       |        \           |            \          /             /    \                |  \          /  |
    * |         \      |         \          |             \        /             /      \               |   \        /   |
    * |          \     |          \         |              \      /             /        \              |    \      /    |
    * |          /     |          /         |               \    /             /          \             |     \    /     |
    * |         /      |         /          |                \  /             /            \            |      \  /      |
    * |        /       |        /           |                 \/             /              \           |       \/       |
    * |_______/        |_______/            |                 |             /________________\          |                |
    * |                |\                   |                 |            /                  \         |                |
    * |                | \                  |                 |           /                    \        |                |
    * |                |  \                 |                 |          /                      \       |                |
    * |                |   \                |                 |         /                        \      |                |
    * |                |    \               |                 |        /                          \     |                |
    * |                |     \              |                 |       /                            \    |                |
    * |                |      \        _____________          |      /                              \   |                |
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCourse = (EditText) findViewById(R.id.etCourse);
        etTeacher = (EditText) findViewById(R.id.etTeacher);
        etClasses = (EditText) findViewById(R.id.etClasses);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        RvList = (RecyclerView) findViewById(R.id.RvList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course NewCourse = new Course(
                        etCourse.getText().toString(),
                        etTeacher.getText().toString(),
                        Integer.parseInt(etClasses.getText().toString())
                );
                courses.add(NewCourse);

                RvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                Adapter myAdapter = new Adapter(
                        MainActivity.this,
                        courses
                );
                RvList.setAdapter(myAdapter);
                etCourse.setText(null);
                etTeacher.setText(null);
                etClasses.setText(null);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
