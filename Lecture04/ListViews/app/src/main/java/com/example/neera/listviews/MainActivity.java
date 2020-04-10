package com.example.neera.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> courselist = new ArrayList<>();
    ListView listView;
   /* String[] courses = new String[]{
            "Pandora",
            "Crux",
            "Launchpad",
            "Algo++",
            "Elixir"
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateCourses(courselist);
        listView = (ListView) findViewById(R.id.listView);

        CourseAdapter courseAdapter = new CourseAdapter(courselist, this);
        listView.setAdapter(courseAdapter);


        /*ArrayAdapter<String> courseListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses);
        listView.setAdapter(courseListAdapter);
        EditText et = new EditText(this);
        FrameLayout fl = (FrameLayout) findViewById(R.id.fb);
        fl.addView(et);*/


    }


    static void generateCourses(ArrayList<Course> courses) {
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 12));
        courses.add(new Course("Perception", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 12));
        courses.add(new Course("Perception", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 12));
        courses.add(new Course("Perception", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 12));
        courses.add(new Course("Perception", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
    }

}

