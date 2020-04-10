package com.example.neera.lva2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neera.lva2.Activities.CenterListActivity;
import com.example.neera.lva2.Activities.CourseListActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCourse, btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCourse = (Button) findViewById(R.id.btnCourse);
        btnCenter = (Button) findViewById(R.id.btnCenter);

        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntCourse = new Intent(MainActivity.this, CourseListActivity.class);
                startActivity(IntCourse);
            }
        });

        btnCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntCenter = new Intent(MainActivity.this, CenterListActivity.class);
                startActivity(IntCenter);
            }
        });
    }
}
