package com.example.neera.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "SRVC";

    Button btnRstrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRstrt = (Button) findViewById(R.id.btnRstrt);

        btnRstrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*PendingIntent pi = PendingIntent.getActivity(
                        MainActivity.this,
                        111,
                        new Intent(MainActivity.this, MainActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );*/

                Log.d(TAG, "onClick: ");
                PendingIntent pi = PendingIntent.getService(
                        MainActivity.this,
                        111,
                        new Intent(MainActivity.this, StartAlarm.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

                am.set(
                        AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + (30 * 1000),
                        pi
                );

            }
        });


    }
}
