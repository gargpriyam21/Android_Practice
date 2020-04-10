package me.rishabhkhanna.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String action = "some.Intent.Action";
    Button btnBroadcast;
    BroadcastReceiver receiver;
    IntentFilter intentFilter;
    TextView tvLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBroadcast = (Button) findViewById(R.id.btnBroadcast);
        tvLevel = (TextView) findViewById(R.id.tvBattery);
        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(action);
                sendBroadcast(i);
            }
        });


        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
                    int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
                    int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,100);
                    if(level != -1){
                        tvLevel.setText(String.valueOf(((float) level/(float)scale) * 100));
                    }
                }

            }
        };


        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);



    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }
}
