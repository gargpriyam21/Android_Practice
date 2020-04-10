package com.example.neera.listviewassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neera.listviewassignment.activities.CenterListActivity;
import com.example.neera.listviewassignment.activities.CourseListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCourse, btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCenter).setOnClickListener(this);
        findViewById(R.id.btnCourse).setOnClickListener(this);


//        btnCourse = (Button) findViewById(R.id.btnCourse);
//        btnCenter = (Button) findViewById(R.id.btnCenter);

        /*btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intcourse = new Intent(MainActivity.this, CourseListActivity.class);
                startActivity(Intcourse);
            }
        });

        btnCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intcenter = new Intent(MainActivity.this, CenterListActivity.class);
                startActivity(Intcenter);
            }
        });*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCenter:
                startActivity(new Intent(getApplicationContext(),CenterListActivity.class));
                break;
            case R.id.btnCourse:
                startActivity(new Intent(this, CourseListActivity.class));
                break;
        }
    }
}
