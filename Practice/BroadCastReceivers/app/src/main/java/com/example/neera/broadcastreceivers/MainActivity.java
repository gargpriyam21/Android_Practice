package com.example.neera.broadcastreceivers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnbr;
    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbr = (Button) findViewById(R.id.btnbr);
        btnbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intent.putExtra("data", "Notice Me");
                myBroadcastReceiver.onReceive(MainActivity.this, intent);
            }
        });

    }
}
