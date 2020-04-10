package com.example.neera.lva2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.lva2.Adapters.CenterRecyclerAdapter;
import com.example.neera.lva2.Models.Center;
import com.example.neera.lva2.R;

public class CenterListActivity extends AppCompatActivity {

    RecyclerView rvCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_list);

        rvCenter = (RecyclerView) findViewById(R.id.rvCenters);
        rvCenter.setLayoutManager(new LinearLayoutManager(this));

        rvCenter.setAdapter(new CenterRecyclerAdapter(
                this,
                Center.generateCenters(50)
        ));
    }
}
