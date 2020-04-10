package com.example.neera.friendsquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.neera.friendsquiz.activities.Activity_History;
import com.example.neera.friendsquiz.activities.Activity_Instructions;
import com.example.neera.friendsquiz.activities.Activity_LR;
import com.example.neera.friendsquiz.activities.Activity_Media;
import com.example.neera.friendsquiz.activities.Activity_Quiz;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnLR, btnInstructions, btnHistory;
    MediaPlayer mp;
    private int flag = 0, play = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //TODO: change name of app
        //TODO: check database
        //TODO: change logo
        //TODO: set timer

        play = getIntent().getIntExtra("play", 0);


        if (play == 0) {
            startActivity(new Intent(this, Activity_Media.class));
        }

        btnStart = (Button) findViewById(R.id.btnStart);
        btnLR = (Button) findViewById(R.id.btnLR);
        btnInstructions = (Button) findViewById(R.id.btnInstructions);
        btnHistory = (Button) findViewById(R.id.btnHistory);

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;
                switch (view.getId()) {
                    case R.id.btnStart:
                        flag = 1;
                        i = new Intent(MainActivity.this, Activity_Quiz.class);
                        break;
                    case R.id.btnLR:
                        flag = 1;
                        i = new Intent(MainActivity.this, Activity_LR.class);
                        break;
                    case R.id.btnInstructions:
                        i = new Intent(MainActivity.this, Activity_Instructions.class);
                        break;
                    case R.id.btnHistory:
                        i = new Intent(MainActivity.this, Activity_History.class);
                        break;
                }
                startActivity(i);
                Finish(flag);
            }
        };

        btnStart.setOnClickListener(onButtonClickListener);
        btnLR.setOnClickListener(onButtonClickListener);
        btnInstructions.setOnClickListener(onButtonClickListener);
        btnHistory.setOnClickListener(onButtonClickListener);
    }

    private void Finish(int flag) {
        if (flag == 1) {
            finish();
        }
    }
}

