package com.example.neera.listviewassignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.listviewassignment.R;
import com.example.neera.listviewassignment.adapters.CourseRecyclerAdapter;
import com.example.neera.listviewassignment.models.Course;

public class CourseListActivity extends AppCompatActivity {

    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        rvCourses = (RecyclerView) findViewById(R.id.rvcourse);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));

        rvCourses.setAdapter(new CourseRecyclerAdapter(
                this,
                Course.generatecourse(50)
        ));


    }
}
