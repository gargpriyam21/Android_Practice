package com.example.neera.lva2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.lva2.Adapters.CourseRecyclerAdapter;
import com.example.neera.lva2.Models.Course;
import com.example.neera.lva2.R;

public class CourseListActivity extends AppCompatActivity {

    RecyclerView rvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        rvCourse = (RecyclerView) findViewById(R.id.rvCourses);
        rvCourse.setLayoutManager(new LinearLayoutManager(this));

        rvCourse.setAdapter(new CourseRecyclerAdapter(
                this,
                Course.generateCourses(50)
        ));

    }
}
