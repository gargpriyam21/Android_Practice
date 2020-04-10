package com.example.neera.animations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivAnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAnd = findViewById(R.id.ivAnd);

        findViewById(R.id.btnSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        MainActivity.this,
                        SecondActivity.class
                );
                ActivityOptions transitionOptions =
                        ActivityOptions.makeSceneTransitionAnimation(
                                MainActivity.this, ivAnd, "backup");

                startActivity(i, transitionOptions.toBundle());
            }
        });
    }
}
