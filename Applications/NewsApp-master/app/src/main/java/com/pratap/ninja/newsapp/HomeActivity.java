package com.pratap.ninja.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private static long SPLASH_TIMEOUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent i = new Intent(HomeActivity.this, MainActivity.class);
                                          startActivity(i);
                                          finish();
                                      }
                                  }, SPLASH_TIMEOUT
        );
    }
}
