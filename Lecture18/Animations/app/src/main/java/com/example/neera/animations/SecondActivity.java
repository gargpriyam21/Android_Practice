package com.example.neera.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView ivAnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivAnd = findViewById(R.id.ivAnd);
    }
}
