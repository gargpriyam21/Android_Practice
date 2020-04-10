package com.example.neera.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "AL";

    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exit = (Button) findViewById(R.id.Exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Toast.makeText(this, "HelloThere!!", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onCreate: ");    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");    
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    int count=0;
    int backprssed=0;
    @Override
    public void onBackPressed() {
        long currenttime = System.currentTimeMillis();
        if(count==0) {
            Toast.makeText(this, "Click Back Twice To Exit", Toast.LENGTH_SHORT).show();
            count++;
        }else {
            super.onBackPressed();
        }
    }
}