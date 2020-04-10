package com.example.neera.listviewassignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.listviewassignment.R;
import com.example.neera.listviewassignment.adapters.CenterRcyclerAdapter;
import com.example.neera.listviewassignment.models.Center;

public class CenterListActivity extends AppCompatActivity {

    RecyclerView rvCenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        rvCenters = (RecyclerView) findViewById(R.id.rvcenter);
        rvCenters.setLayoutManager(new LinearLayoutManager(this));

        rvCenters.setAdapter(new CenterRcyclerAdapter(
                this,
                Center.generateCenters(50)
        ));


    }
}
